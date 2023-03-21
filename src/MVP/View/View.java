package MVP.View;

import Toys.BaseToy;

public abstract class View {

    protected String firstMessage() {
        return "### МЫ В ГЛАВНОМ МЕНЮ ###\n";
    }

    protected String mainMenu() {
        return """
                1: Добавить Игрушку
                2: Изменить количество игрушек
                3: Провести розыгрыш
                4: Выдать Игрушку
                5: Посмотреть список игрушек
                6: Посмотреть список участников
                0: Выход
                            
                Выберите пункт меню:""";
    }


    // Добавить игрушку
    protected String addToyName() {
        return "Введите название игрушки: ";
    }

    protected String addToyCount() {
        return "Введите количество: ";
    }

    protected String addToyRarity() {
        return "Выберите ценность игрушки: \n" +
                "1 - ценная\n" +
                "2 - раритет\n" +
                "3 - антиквариат\n";
    }

    protected String addToyFinal() {
        return "Игрушка успешно добавлена!\n";
    }


    // Изменить количество
    protected String changeCountFirst() {
        return "Введите id игрушки, количество которой хотите изменить: ";
    }

    protected String changeCountSecond() {
        return "Введите нужное количество: ";
    }

    protected String changeCountFinal() {
        return "Количество успешно изменено!\n";
    }


    // Розыгрыш
    protected String lotteryFirst() {
        return "Введите имя участника розыгрыша: ";
    }

    protected String lotterySecond() {
        return "Отсутстыуют игрушки, подходящие для розыгрыша!\n";
    }

    protected String lotteryFinal(String winnerName, String toyName) {
        return "# # # # # # #\n" + winnerName + " выиграл(-а) игрушку " + toyName + "!!!\n# # # # # # #" + "\n";
    }


    // Выдача игрушек
    protected String releaseFirst() {
        return "Введите id участника, которому необходимо выдать игрушку: ";
    }

    protected String releaseFinal(String winnerName, String toyName) {
        return "# # # # # # #\n" + winnerName + " получил(-а) игрушку " + toyName + "!!!\n# # # # # # #" + "\n";
    }


    // Список игрушек, участников
    protected String Separator() {
        return "\n#$#$#$#$#$#$#$#$#$##$#$#$#$#$#$#$#$#$##$#$#$#$#$#$#$#$#$#\n";
    }


    // Ошибка ввода
    protected String inputError() {
        return "Ошибка ввода";
    }


}
