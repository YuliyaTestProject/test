import org.testng.annotations.*;
import org.testng.Assert;

public class TestsTicTacToe {

    private TicTacToe test = new TicTacToe();

    @Test()
    public void testMatrixSize() {

        Assert.assertEquals(test.getMatrixSize(), 3, "Matrix's size doesn't match expected one!");

    }

    @Test()
    public void testEmptyMatrix() {

        test.drawMatrix();
        Assert.assertEquals(test.getMatrixLastInput(), '.', "Matrix's element contains incorrect character!");

    }


    @DataProvider(name = "test2")
    public static Object[][] numbers1() {
        return new Object[][]{{"0,0"}, {"0,1"}};

    }

    @Test(dataProvider = "test2")
    public void testNumbers(String num) {
        System.out.println(num);
        test.isUserInputValid(num);
    }


    @Test()
    public void testValidUserInput() {

        Assert.assertTrue(test.isUserInputValid("0,0"));
        Assert.assertTrue(test.isUserInputValid("0,1"));
        Assert.assertTrue(test.isUserInputValid("1,0"));
        Assert.assertTrue(test.isUserInputValid("1,1"));
        Assert.assertTrue(test.isUserInputValid("0,2"));
        Assert.assertTrue(test.isUserInputValid("1,2"));
        Assert.assertTrue(test.isUserInputValid("2,2"));
        Assert.assertTrue(test.isUserInputValid("2,0"));

    }

    @Test()
    public void testInvalidUserInput() {

        Assert.assertFalse(test.isUserInputValid("a,b"));
        Assert.assertFalse(test.isUserInputValid("4,7"));
        Assert.assertFalse(test.isUserInputValid("-8,0"));
        Assert.assertFalse(test.isUserInputValid("62.3,0"));
        Assert.assertFalse(test.isUserInputValid("100,333"));
        Assert.assertFalse(test.isUserInputValid("sdfdsf,DFSDJFJ"));
        Assert.assertFalse(test.isUserInputValid("@#$*@(,@!#(@_)($"));
        Assert.assertFalse(test.isUserInputValid(" , "));
        Assert.assertFalse(test.isUserInputValid(""));

    }


    @Test()
    public void testIsWinner() {

        test.putMarkAtCoordinate(0, 0, 'X');
        test.putMarkAtCoordinate(0, 1, 'X');
        test.putMarkAtCoordinate(0, 2, 'X');
        Assert.assertTrue(test.isWinner(test.getLastInputX(), test.getLastInputY()));


    }

    @Test()
    public void testSaveUserInputAsCoordinate() {

        test.saveUserInputAsCoordinate("1,1");
        Assert.assertEquals(test.getLastInputX(), 1);
        Assert.assertEquals(test.getLastInputY(), 1);


    }

    @Test()
    public void testPutMarkAtCoordinate() {

        test.putMarkAtCoordinate(0, 0, 'X');
        Assert.assertEquals(test.getPlayerMark(), 'X');
        Assert.assertEquals(test.getLastInputX(), 0);
        Assert.assertEquals(test.getLastInputY(), 0);

    }


    @Test()
    public void testPlayerMark() {

        System.out.println(test.getPlayerMark());
        test.setPlayerMark("Player 1");
        Assert.assertEquals(test.getPlayerMark(), 'X');

    }


}
