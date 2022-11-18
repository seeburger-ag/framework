package com.vaadin.tests.components.grid.basicfeatures.escalator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.vaadin.testbench.TestBenchElement;
import com.vaadin.tests.components.grid.basicfeatures.EscalatorBasicClientFeaturesTest;

public class EscalatorRowColumnTest extends EscalatorBasicClientFeaturesTest {

    /**
     * The scroll position of the Escalator when scrolled all the way down, to
     * reveal the 100:th row.
     */
    private static final int BOTTOM_SCROLL_POSITION = 1857;

    @Test
    public void testInit() {
        openTestURL();
        assertNotNull(getEscalator());
        assertNull(getHeaderRow(0));
        assertNull(getBodyRow(0));
        assertNull(getFooterRow(0));

        assertLogContains("Columns: 0");
        assertLogContains("Header rows: 0");
        assertLogContains("Body rows: 0");
        assertLogContains("Footer rows: 0");
    }

    @Test
    public void testInsertAColumn() {
        openTestURL();

        selectMenuPath(COLUMNS_AND_ROWS, COLUMNS, ADD_ONE_COLUMN_TO_BEGINNING);
        assertNull(getHeaderRow(0));
        assertNull(getBodyRow(0));
        assertNull(getFooterRow(0));
        assertLogContains("Columns: 1");
    }

    @Test
    public void testInsertAHeaderRow() {
        openTestURL();

        selectMenuPath(COLUMNS_AND_ROWS, HEADER_ROWS, ADD_ONE_ROW_TO_BEGINNING);
        assertNull(getHeaderCell(0, 0));
        assertNull(getBodyCell(0, 0));
        assertNull(getFooterCell(0, 0));
        assertLogContains("Header rows: 1");
    }

    @Test
    public void testInsertABodyRow() {
        openTestURL();

        selectMenuPath(COLUMNS_AND_ROWS, BODY_ROWS, ADD_ONE_ROW_TO_BEGINNING);
        assertNull(getHeaderCell(0, 0));
        assertNull(getBodyCell(0, 0));
        assertNull(getFooterCell(0, 0));
        assertLogContains("Body rows: 1");
    }

    @Test
    public void testInsertAFooterRow() {
        openTestURL();

        selectMenuPath(COLUMNS_AND_ROWS, FOOTER_ROWS, ADD_ONE_ROW_TO_BEGINNING);
        assertNull(getHeaderCell(0, 0));
        assertNull(getBodyCell(0, 0));
        assertNull(getFooterCell(0, 0));
        assertLogContains("Footer rows: 1");
    }

    @Test
    public void testInsertAColumnAndAHeaderRow() {
        openTestURL();

        selectMenuPath(COLUMNS_AND_ROWS, COLUMNS, ADD_ONE_COLUMN_TO_BEGINNING);
        selectMenuPath(COLUMNS_AND_ROWS, HEADER_ROWS, ADD_ONE_ROW_TO_BEGINNING);
        assertNotNull(getHeaderCell(0, 0));
        assertNull(getBodyCell(0, 0));
        assertNull(getFooterCell(0, 0));
        assertLogContains("Columns: 1");
        assertLogContains("Header rows: 1");
    }

    @Test
    public void testInsertAColumnAndABodyRow() {
        openTestURL();

        selectMenuPath(COLUMNS_AND_ROWS, COLUMNS, ADD_ONE_COLUMN_TO_BEGINNING);
        selectMenuPath(COLUMNS_AND_ROWS, BODY_ROWS, ADD_ONE_ROW_TO_BEGINNING);
        assertNull(getHeaderCell(0, 0));
        assertNotNull(getBodyCell(0, 0));
        assertNull(getFooterCell(0, 0));
        assertLogContains("Columns: 1");
        assertLogContains("Body rows: 1");
    }

    @Test
    public void testInsertAColumnAndAFooterRow() {
        openTestURL();

        selectMenuPath(COLUMNS_AND_ROWS, COLUMNS, ADD_ONE_COLUMN_TO_BEGINNING);
        selectMenuPath(COLUMNS_AND_ROWS, FOOTER_ROWS, ADD_ONE_ROW_TO_BEGINNING);
        assertNull(getHeaderCell(0, 0));
        assertNull(getBodyCell(0, 0));
        assertNotNull(getFooterCell(0, 0));
        assertLogContains("Columns: 1");
        assertLogContains("Footer rows: 1");
    }

    @Test
    public void testInsertAHeaderRowAndAColumn() {
        openTestURL();

        selectMenuPath(COLUMNS_AND_ROWS, HEADER_ROWS, ADD_ONE_ROW_TO_BEGINNING);
        selectMenuPath(COLUMNS_AND_ROWS, COLUMNS, ADD_ONE_COLUMN_TO_BEGINNING);
        assertNotNull(getHeaderCell(0, 0));
        assertNull(getBodyCell(0, 0));
        assertNull(getFooterCell(0, 0));
        assertLogContains("Columns: 1");
        assertLogContains("Header rows: 1");
    }

    @Test
    public void testInsertABodyRowAndAColumn() {
        openTestURL();

        selectMenuPath(COLUMNS_AND_ROWS, BODY_ROWS, ADD_ONE_ROW_TO_BEGINNING);
        selectMenuPath(COLUMNS_AND_ROWS, COLUMNS, ADD_ONE_COLUMN_TO_BEGINNING);
        assertNull(getHeaderCell(0, 0));
        assertNotNull(getBodyCell(0, 0));
        assertNull(getFooterCell(0, 0));
        assertLogContains("Columns: 1");
        assertLogContains("Body rows: 1");
    }

    @Test
    public void testInsertAFooterRowAndAColumn() {
        openTestURL();

        selectMenuPath(COLUMNS_AND_ROWS, FOOTER_ROWS, ADD_ONE_ROW_TO_BEGINNING);
        selectMenuPath(COLUMNS_AND_ROWS, COLUMNS, ADD_ONE_COLUMN_TO_BEGINNING);
        assertNull(getHeaderCell(0, 0));
        assertNull(getBodyCell(0, 0));
        assertNotNull(getFooterCell(0, 0));
        assertLogContains("Columns: 1");
        assertLogContains("Footer rows: 1");
    }

    @Test
    public void testFillColRow() {
        openTestURL();

        selectMenuPath(GENERAL, POPULATE_COLUMN_ROW);
        scrollVerticallyTo(2000); // more like 1857, but this should be enough.

        // if not found, an exception is thrown here
        waitUntilCellPresent("Cell: 9,99");
    }

    @Test
    public void testFillRowCol() {
        openTestURL();

        selectMenuPath(GENERAL, POPULATE_ROW_COLUMN);
        scrollVerticallyTo(2000); // more like 1857, but this should be enough.

        // if not found, an exception is thrown here
        waitUntilCellPresent("Cell: 9,99");
    }

    @Test
    public void testClearColRow() {
        openTestURL();

        selectMenuPath(GENERAL, POPULATE_COLUMN_ROW);
        selectMenuPath(GENERAL, CLEAR_COLUMN_ROW);

        assertNull(getBodyCell(0, 0));
    }

    @Test
    public void testClearRowCol() {
        openTestURL();

        selectMenuPath(GENERAL, POPULATE_COLUMN_ROW);
        selectMenuPath(GENERAL, CLEAR_ROW_COLUMN);

        assertNull(getBodyCell(0, 0));
    }

    @Test
    public void testResizeColToFit() {
        openTestURL();
        selectMenuPath(GENERAL, POPULATE_COLUMN_ROW);

        selectMenuPath(COLUMNS_AND_ROWS, COLUMNS, RESIZE_FIRST_COLUMN_TO_100PX);
        int originalWidth = getBodyCell(0, 0).getSize().getWidth();

        assertEquals(100, originalWidth);

        selectMenuPath(COLUMNS_AND_ROWS, COLUMNS,
                RESIZE_FIRST_COLUMN_TO_MAX_WIDTH);
        int newWidth = getBodyCell(0, 0).getSize().getWidth();
        assertNotEquals("Column width should've changed", originalWidth,
                newWidth);
    }

    @Test
    public void testRemoveMoreThanPagefulAtBottomWhileScrolledToBottom()
            throws Exception {
        openTestURL();
        selectMenuPath(GENERAL, POPULATE_COLUMN_ROW);

        scrollVerticallyTo(BOTTOM_SCROLL_POSITION);
        selectMenuPath(COLUMNS_AND_ROWS, BODY_ROWS, REMOVE_50_ROWS_FROM_BOTTOM);

        waitUntilCellPresent(-1, 0, "Row 49: 0,49");

        scrollVerticallyTo(0);

        // if something goes wrong, it'll explode before this.
        waitUntilCellPresent(0, 0, "Row 0: 0,0");
    }

    @Test
    public void testRemoveMoreThanPagefulAtBottomWhileScrolledAlmostToBottom()
            throws Exception {
        openTestURL();
        selectMenuPath(GENERAL, POPULATE_COLUMN_ROW);

        // bottom minus 15 rows.
        scrollVerticallyTo(BOTTOM_SCROLL_POSITION - 15 * 20);
        selectMenuPath(COLUMNS_AND_ROWS, BODY_ROWS, REMOVE_50_ROWS_FROM_BOTTOM);

        waitUntilCellPresent(-1, 0, "Row 49: 0,49");

        scrollVerticallyTo(0);

        // if something goes wrong, it'll explode before this.
        waitUntilCellPresent(0, 0, "Row 0: 0,0");
    }

    @Test
    public void testRemoveMoreThanPagefulNearBottomWhileScrolledToBottom()
            throws Exception {
        openTestURL();
        selectMenuPath(GENERAL, POPULATE_COLUMN_ROW);

        scrollVerticallyTo(BOTTOM_SCROLL_POSITION);
        selectMenuPath(COLUMNS_AND_ROWS, BODY_ROWS,
                REMOVE_50_ROWS_FROM_ALMOST_BOTTOM);

        waitUntilCellPresent(-1, 0, "Row 49: 0,99");

        scrollVerticallyTo(0);

        // if something goes wrong, it'll explode before this.
        waitUntilCellPresent(0, 0, "Row 0: 0,0");
    }

    @Test
    public void testRemoveMoreThanPagefulNearBottomWhileScrolledAlmostToBottom()
            throws Exception {
        openTestURL();
        selectMenuPath(GENERAL, POPULATE_COLUMN_ROW);

        // bottom minus 15 rows.
        scrollVerticallyTo(BOTTOM_SCROLL_POSITION - 15 * 20);
        selectMenuPath(COLUMNS_AND_ROWS, BODY_ROWS,
                REMOVE_50_ROWS_FROM_ALMOST_BOTTOM);

        waitUntilCellPresent(-1, 0, "Row 49: 0,99");

        scrollVerticallyTo(0);

        // if something goes wrong, it'll explode before this.
        waitUntilCellPresent(0, 0, "Row 0: 0,0");
    }

    private void waitUntilCellPresent(final String content) {
        waitUntil(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver arg0) {
                return isElementPresent(
                        By.xpath("//td[text()='" + content + "']"));
            }

            @Override
            public String toString() {
                // waiting for ...
                return "the cell '" + content + "' to become visible";
            }
        });
    }

    private void waitUntilCellPresent(final int row, final int col,
            final String content) {
        waitUntil(new ExpectedCondition<Boolean>() {
            String actual;

            @Override
            public Boolean apply(WebDriver arg0) {
                TestBenchElement cell = getBodyCell(row, col);
                if (cell == null) {
                    return false;
                }
                actual = cell.getText();
                return content.equals(actual);
            }

            @Override
            public String toString() {
                // waiting for ...
                return "the content of cell (" + row + ", " + col
                        + ") to become '" + content + "' (was: '" + actual
                        + "')";
            }
        });
    }
}
