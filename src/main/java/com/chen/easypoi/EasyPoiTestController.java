package com.chen.easypoi;

import com.chen.util.FileUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chen weijie
 * @date 2018-01-19 12:08 AM
 */
@Controller
public class EasyPoiTestController {

    public void export(HttpServletResponse response) {
        //模拟从数据库获取需要导出的数据
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("路飞", "1", new Date());
        Person person2 = new Person("娜美", "2", DateUtils.addDays(new Date(), 3));
        Person person3 = new Person("索隆", "1", DateUtils.addDays(new Date(), 10));
        Person person4 = new Person("小狸猫", "1", DateUtils.addDays(new Date(), -10));
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        //导出操作
        FileUtil.exportExcel(personList,"花名册","草帽一伙",Person.class,"海贼王.xls",response);
    }

}
