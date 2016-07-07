package ua.suputilov.texthandlersystem.textfile;

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
import ua.suputilov.texthandlersystem.dao.TextFileDao;
import ua.suputilov.texthandlersystem.model.Text;
import ua.suputilov.texthandlersystem.model.TextFile;
import ua.suputilov.texthandlersystem.utils.TextHandler;

/**
 * Created by sergey_putilov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class TextFileTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private TextFileDao textFileDao;

    @Autowired
    private TextHandler textHandler;

    @Test
    @Transactional
    public void getAllTextFilesTest() {
        System.out.println("-------------------------");
        System.out.println("getAllTextFilesTest()");
        System.out.println("-------------------------");

//        List<TextFile> textFiles = textFileDao.getAllTextFiles();
//        assertNotNull(textFiles);
    }

    @Test
    @Transactional
    public void handleTextTest() {
        System.out.println("-------------------------");
        System.out.println("handleTextTest()");
        System.out.println("-------------------------");

        Text text = new Text();
        text.setText("The test text string one."
                + "\n" + "The test text string two."
                + "\n" + "The test text string three.");
        TextFile webText = textHandler.processText(text);

        assertNotNull(webText);
    }

    @Test
    @Transactional
    public void getTextFilesByMinCountLineCriteriaTest() {
        System.out.println("-------------------------");
        System.out.println("getTextFilesByMinCountLineCriteriaTest()");
        System.out.println("-------------------------");

//        List<TextFile> textFiles = textFileDao.getTextFilesByMinCountLineCriteria(5);
//        assertNotNull(textFiles);
    }
}
