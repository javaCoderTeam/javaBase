package com.chen.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 服务端生产者对象
 * <p>
 * Netty中，通讯的双方建立连接后，会把数据按照ByteBuf的方式进行传输，
 * 例如http协议中，就是通过HttpRequestDecoder对ByteBuf数据流进行处理，转换成http的对象。
 * 深入学习：
 * https://www.cnblogs.com/katsura/p/5991428.html
 * https://www.cnblogs.com/stevenczp/p/7581940.html
 *
 * @author :  chen weijie
 * @Date: 2019-10-18 18:46
 */
public class ServerTest {


    /**
     * 服务端口
     */
    private int port = 9999;


    /**
     * 开启服务
     */
    public void startNetty() {

        /**
         * 创建两个EventLoop的组，EventLoop 这个相当于一个处理线程，
         是Netty接收请求和处理IO请求的线程。不理解的话可以百度NIO图解
         相关资料：NioEventLoopGroup是一个处理I/O操作的多线程事件循环。
         Netty为不同类型的传输提供了各种EventLoopGroup实现。
         在本例中，我们正在实现一个服务器端应用程序，因此将使用两个NioEventLoopGroup。
         第一个，通常称为“boss”，接受传入的连接。
         第二个，通常称为“worker”，当boss接受连接并注册被接受的连接到worker时，处理被接受连接的流量。
         使用了多少线程以及如何将它们映射到创建的通道取决于EventLoopGroup实现，甚至可以通过构造函数进行配置。
         */

        EventLoopGroup acceptor = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        // 创建启动类
        ServerBootstrap bootstrap = new ServerBootstrap();

        //2、配置启动参数等
        /**设置循环线程组，前者用于处理客户端连接事件，后者用于处理网络IO(server使用两个参数这个)
         *public ServerBootstrap group(EventLoopGroup group)
         *public ServerBootstrap group(EventLoopGroup parentGroup, EventLoopGroup childGroup)
         */

        bootstrap.group(acceptor, worker);


        /**设置选项
         * 参数：Socket的标准参数（key，value），可自行百度
         * eg:
         * bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
         *bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
         * */

        bootstrap.option(ChannelOption.SO_BACKLOG,1024);
        //用于构造socketchannel工厂
        bootstrap.channel(NioServerSocketChannel.class);

        /**
         * 传入自定义客户端Handle（服务端在这里搞事情）
         */
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new SimpleServerHandler());
            }
        });

        // 绑定端口，开始接收进来的连接
        ChannelFuture f;
        try {
            f = bootstrap.bind(port).sync();
            // 等待服务器 socket 关闭 。
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            acceptor.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new ServerTest().startNetty();

    }


}
