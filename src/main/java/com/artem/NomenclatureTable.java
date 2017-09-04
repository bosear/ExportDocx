package com.artem;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by Артём on 25.04.2017.
 */
public class NomenclatureTable extends DetailsComplexionTable {

    public NomenclatureTable() throws IOException {
        document = new XWPFDocument();
        out = new FileOutputStream(new File("nomenclature_table.docx"));

        changeOrientationA4();

        renderAllTables();

        finish();
    }

    @Override
    protected void finish() throws IOException {
        document.write(out);
        out.close();
        System.out.println("nomenclature_table.docx written successfully");
    }

    @Override
    protected void renderAllTables() {
        XWPFTable table = createHeaderTable("");
        //renderContent(table, FactoryEquipments.getAllEquipments());
        // здесь вроде бы надо дописать заполнение всей таблицы, но т.к. данная таблица имеет ячейки 1:1 (нету смёрженных),
        // то это просто пробежать в for-e
        // короче переопределить renderContent()
    }

    @Override
    protected XWPFTable createHeaderTable(String title) {
        XWPFTable table = document.createTable(4, 7);
        table.setCellMargins(20, 100, 20, 100); // отступы внутри ячеек таблицы
        XWPFTableRow rowOne = table.getRow(0);
        XWPFTableRow rowTwo = table.getRow(1);
        XWPFTableRow rowThree = table.getRow(2);
        XWPFTableRow rowFor = table.getRow(3);

        // Настройки размеров таблицы и шапки таблицы
        //table.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(17000));
        CTTcPr tcPr = CTTcPr.Factory.newInstance();
        tcPr.addNewTcW().setW(BigInteger.valueOf(1100));
        rowOne.getCell(0).getCTTc().setTcPr(tcPr);

        tcPr = CTTcPr.Factory.newInstance();
        tcPr.addNewTcW().setW(BigInteger.valueOf(3800));
        rowOne.getCell(1).getCTTc().setTcPr(tcPr);

        tcPr = CTTcPr.Factory.newInstance();
        tcPr.addNewTcW().setW(BigInteger.valueOf(2000));
        rowOne.getCell(2).getCTTc().setTcPr(tcPr);

        tcPr = CTTcPr.Factory.newInstance();
        tcPr.addNewTcW().setW(BigInteger.valueOf(4000));
        rowOne.getCell(3).getCTTc().setTcPr(tcPr);
        setSingleLineSpacing(rowOne.getCell(3).getParagraphs().get(0));

        tcPr = CTTcPr.Factory.newInstance();
        tcPr.addNewTcW().setW(BigInteger.valueOf(2000));
        rowTwo.getCell(3).getCTTc().setTcPr(tcPr);
        setSingleLineSpacing(rowTwo.getCell(3).getParagraphs().get(0)); // убираем межстрочные интервалы
        setSingleLineSpacing(rowTwo.getCell(4).getParagraphs().get(0)); // убираем межстрочные интервалы

        tcPr = CTTcPr.Factory.newInstance();
        tcPr.addNewTcW().setW(BigInteger.valueOf(2000));
        rowOne.getCell(5).getCTTc().setTcPr(tcPr);

        tcPr = CTTcPr.Factory.newInstance();
        tcPr.addNewTcW().setW(BigInteger.valueOf(2400));
        rowOne.getCell(6).getCTTc().setTcPr(tcPr);

        CTTblLayoutType type = table.getCTTbl().getTblPr().addNewTblLayout();
        type.setType(STTblLayoutType.FIXED);


        // Мёрж ячеек в шапке таблицы
        mergeCellVertically(table, 0, 0, 1);
        mergeCellVertically(table, 1, 0, 1);
        mergeCellVertically(table, 2, 0, 1);

        mergeCellHorizontally(table, 0, 3, 4);

        mergeCellVertically(table, 5, 0, 1);
        mergeCellVertically(table, 6, 0, 1);

        // Настройка стиля и текста для первой строки
        setFontWithAlignment(rowOne.getCell(0), false, true, "№№ п.п.", 14, STVerticalJc.TOP);
        setFontWithAlignment(rowOne.getCell(1), false, true, "Наименование и индекс продукции", 14, STVerticalJc.TOP);
        setFontWithAlignment(rowOne.getCell(2), false, true, "Предприятие-изготовитель (разработчик) продукции", 14, STVerticalJc.TOP);
        setFontWithAlignment(rowOne.getCell(3), false, true, "Заказчики, в интересах которых контролируется продукция ВП МО", 14, STVerticalJc.TOP);
        setFontWithAlignment(rowOne.getCell(5), false, true, "Основание для контроля продукции ВП МО", 14, STVerticalJc.TOP);
        setFontWithAlignment(rowOne.getCell(6), false, true, "Наименование конструкторского (технического) документа, требованиям которого должна соответствовать контролируемая продукция", 14, STVerticalJc.TOP);

        // Настройка стиля и текста для второй строки
        setFontWithAlignment(rowTwo.getCell(3), false, true, "Генеральный заказчик, в чьих интересах контролируется продукция ВП МО", 14, STVerticalJc.TOP);
        setFontWithAlignment(rowTwo.getCell(4), false, true, "Предприятие, являющееся головным, по отношению к предприятию, указанному в графе 3", 14, STVerticalJc.TOP);

        // Настройка стиля и текста для третьей строки
        for (int i = 0; i < 7; i++) {
            setFontWithAlignment(rowThree.getCell(i), false, false, String.valueOf(i + 1), 14, null);
            setSingleLineSpacing(rowThree.getCell(i).getParagraphs().get(0));
        }

        mergeCellHorizontally(table, 3, 0, 6);
        setFontWithAlignment(rowFor.getCell(0), true, false, "1. Научно-исследовательские и опытно-конструкторские работы", 14, null);
        setSingleLineSpacing(rowFor.getCell(0).getParagraphs().get(0));

        return table;
    }


}
