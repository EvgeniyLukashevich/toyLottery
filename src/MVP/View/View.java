package MVP.View;

public abstract class View {

    protected String mainMenu() {
            return """
                        
            1: Добавить Игрушку
            2: Изменить количество игрушек
            3: Провести розыгрыш
            4: Выдать Игрушку
            0: Выход
            
            Выберите пункт меню:             
            """;
    }


    public abstract void showMainMenu();
    public abstract String userInput();
}
