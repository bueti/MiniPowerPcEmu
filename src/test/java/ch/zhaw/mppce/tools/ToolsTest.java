package ch.zhaw.mppce.tools;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 18.10.12
 * Time: 18:42
 */
public class ToolsTest extends TestCase {

    public void testTwoComplement() throws Exception {
        Tools tool = new Tools();

        String a1 = tool.twoComplement(-1);
        Assert.assertEquals("1111111111111111", a1);

        a1 = tool.twoComplement(-3);
        Assert.assertEquals("1111111111111101", a1);

        String b1 = tool.twoComplement(1);
        Assert.assertEquals("0000000000000001", b1);

        b1 = tool.twoComplement(3);
        Assert.assertEquals("0000000000000011", b1);

    }

    public static void main(String[] args) {
        junit.swingui.TestRunner.run(ToolsTest.class);
    }
}
