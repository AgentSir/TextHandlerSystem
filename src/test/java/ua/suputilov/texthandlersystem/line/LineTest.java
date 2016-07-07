package ua.suputilov.texthandlersystem.line;

import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.suputilov.texthandlersystem.dao.LineDao;
import ua.suputilov.texthandlersystem.model.Line;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class LineTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private LineDao lineDao;

    @Test
    @Transactional
    public void getTextLinesByFileIdTest() {
        System.out.println("-------------------------");
        System.out.println("getTextLinesByFileIdTest()");
        System.out.println("-------------------------");
        
//        List<Line> Lines = lineDao.getTextLinesByFileId(10);

//        assertNotNull(Lines);
    }
}
