public class Main {
    public static void main(String[] args) {
        HotelGUI gui = new HotelGUI();
        Model model = new Model();

        Controller controller = new Controller(gui, model);

        gui.setVisible(true);
        model.menu();
    }
}
