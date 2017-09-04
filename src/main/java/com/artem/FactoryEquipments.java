package com.artem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артём on 13.02.2017.
 */
public class FactoryEquipments {

    public static List<Equipment> getAllEquipments() {
        List<Equipment> list = new ArrayList<Equipment>();

        List<Component> components = new ArrayList<Component>();
        components.add( new Component("Обойма", "АК.00.232.343"));
        components.add( new Component("Балка At vero", "БК.00.2342.893"));
        components.add( new Component("Пистон", "СК.00.2.300"));
        components.add( new Component("Кронштейн", "АК.00.236.343"));
        components.add( new Component("Шайба", "ДК.00.152.899"));

        list.add(new Equipment(
                "АК-23-23",
                "Контроль",
                "Сплошной",
                "",
                "33 года",
                "Не требуется",
                "",components
        ));

        list.add(new Equipment(
                "АК-23-23,343/34 ТУ 23242-3434-343424-32423",
                "Контроль сопроводительной документации, комплектность",
                "Сплошной",
                "",
                "33 года",
                "Не требуется",
                "",components
        ));

        list.add(new Equipment(
                "АК-23-23,343/34 ТУ 23242-3434-343424-32423",
                "Контроль сопроводительной документации, комплектность",
                "Сплошной",
                "",
                "33 года",
                "Не требуется",
                "",components
        ));

        list.add(new Equipment(
                "АК-23-23,343/34 ТУ 23242-3434-343424-32423, ",
                "Контроль сопроводительной документации, комплектность",
                "Сплошной",
                "",
                "33 года",
                "Не требуется",
                "",components
        ));

        list.add(new Equipment(
                "АК-23-23,343/34 ТУ 23242-3434-343424-32423",
                "Контроль сопроводительной документации, комплектность",
                "Сплошной",
                "",
                "33 года",
                "Не требуется",
                "",components
        ));
        // Для краш-тестов:
        /*Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque turpis justo, vulputate non nibh quis, ultricies dictum ipsum. Sed fringilla magna at felis varius rutrum. Donec ac sapien at est fringilla pretium vitae sed turpis. Quisque pharetra mattis egestas. Donec rutrum sollicitudin scelerisque*/

        return list;
    }
}
