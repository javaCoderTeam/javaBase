package com.chen.util;

import org.apache.commons.lang3.StringUtils;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Set;


/**
 * http请求工具类
 *
 * @author zhangyong
 */
public class HttpUtils {

    private static final String CTYPE_FORM = "application/x-www-form-urlencoded;charset=utf-8";
    private static final String CTYPE_JSON = "application/json; charset=utf-8";
    private static final String charset = "utf-8";

    private static HttpUtils instance = null;

    public static HttpUtils getInstance() {
        if (instance == null) {
            return new HttpUtils();
        }
        return instance;
    }

    private static class DefaultTrustManager implements X509TrustManager {
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }
    }

    /**
     * 以application/json; charset=utf-8方式传输
     *
     * @param url
     * @return
     * @throws SocketTimeoutException
     * @throws IOException
     */
    public static String postJson(String url, String jsonContent)
            throws SocketTimeoutException, IOException {
        return doRequest("POST", url, jsonContent, 15000, 15000, CTYPE_JSON,
                null);
    }

    /**
     * POST 以application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url
     * @return
     * @throws SocketTimeoutException
     * @throws IOException
     */
    public static String postForm(String url) throws SocketTimeoutException,
            IOException {
        return doRequest("POST", url, "", 15000, 15000, CTYPE_FORM, null);
    }

    /**
     * POST 以application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url
     * @return
     * @throws SocketTimeoutException
     * @throws IOException
     */
    public static String postForm(String url, Map<String, String> params)
            throws SocketTimeoutException, IOException {
        return doRequest("POST", url, buildQuery(params), 15000, 15000,
                CTYPE_FORM, null);
    }

    /**
     * POST 以application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url
     * @return
     * @throws SocketTimeoutException
     * @throws IOException
     */
    public static String getForm(String url) throws SocketTimeoutException,
            IOException {
        return doRequest("GET", url, "", 15000, 15000, CTYPE_FORM, null);
    }

    /**
     * POST 以application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url
     * @return
     * @throws SocketTimeoutException
     * @throws IOException
     */
    public static String getForm(String url, Map<String, String> params)
            throws SocketTimeoutException, IOException {
        return doRequest("GET", url, buildQuery(params), 15000, 15000,
                CTYPE_FORM, null);
    }


    private static String doRequest(String method, String url, String requestContent,
                                    int connectTimeout, int readTimeout, String ctype,
                                    Map<String, String> headerMap) throws SocketTimeoutException,
            IOException {
        HttpURLConnection conn = null;
        OutputStream out = null;
        String rsp = null;
        try {
            conn = getConnection(new URL(url), method, ctype, headerMap);
            conn.setConnectTimeout(connectTimeout);
            conn.setReadTimeout(readTimeout);

            if (!StringUtils.isEmpty(requestContent)) {
                out = conn.getOutputStream();
                out.write(requestContent.getBytes(charset));
            }

            rsp = getResponseAsString(conn);
        } finally {
            if (out != null) {
                out.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
            conn = null;
        }
        return rsp;
    }

    private static HttpURLConnection getConnection(URL url, String method,
                                                   String ctype, Map<String, String> headerMap) throws IOException {
        HttpURLConnection conn;
        if ("https".equals(url.getProtocol())) {
            SSLContext ctx;
            try {
                ctx = SSLContext.getInstance("TLS");
                ctx.init(new KeyManager[0],
                        new TrustManager[]{new DefaultTrustManager()},
                        new SecureRandom());
            } catch (Exception e) {
                throw new IOException(e);
            }
            HttpsURLConnection connHttps = (HttpsURLConnection) url
                    .openConnection();
            connHttps.setSSLSocketFactory(ctx.getSocketFactory());
            connHttps.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            conn = connHttps;
        } else {
            conn = (HttpURLConnection) url.openConnection();
        }
        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Accept",
                "text/xml,text/javascript,text/html,application/json");
        conn.setRequestProperty("Content-Type", ctype);
        if (headerMap != null) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        return conn;
    }

    private static String getResponseAsString(HttpURLConnection conn)
            throws IOException {
        InputStream es = conn.getErrorStream();
        if (es == null) {
            return getStreamAsString(conn.getInputStream(), charset, conn);
        } else {
            String msg = getStreamAsString(es, charset, conn);
            if (StringUtils.isEmpty(msg)) {
                throw new IOException(conn.getResponseCode() + ":"
                        + conn.getResponseMessage());
            } else {
                return msg;
            }
        }
    }

    private static String getStreamAsString(InputStream stream, String charset,
                                            HttpURLConnection conn) throws IOException {
        try {
            Reader reader = new InputStreamReader(stream, charset);

            StringBuilder response = new StringBuilder();
            final char[] buff = new char[1024];
            int read = 0;
            while ((read = reader.read(buff)) > 0) {
                response.append(buff, 0, read);
            }

            return response.toString();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    private static String buildQuery(Map<String, String> params) throws IOException {
        if (params == null || params.isEmpty()) {
            return "";
        }

        StringBuilder query = new StringBuilder();
        Set<Map.Entry<String, String>> entries = params.entrySet();
        boolean hasParam = false;

        for (Map.Entry<String, String> entry : entries) {
            String name = entry.getKey();
            String value = entry.getValue();
            if (hasParam) {
                query.append("&");
            } else {
                hasParam = true;
            }
            query.append(name).append("=")
                    .append(URLEncoder.encode(value, charset));
        }
        return query.toString();
    }
}