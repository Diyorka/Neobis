import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws SQLException {

        Laptop laptop1 = new Laptop("Apple", "Macbook Pro", 99000);
        Laptop laptop2 = new Laptop("Lenovo", "Thinkpad", 70000);
        Laptop laptop3 = new Laptop("Asus", "TUF", 105000);
        insertLaptop(laptop1);
        insertLaptop(laptop2);
        insertLaptop(laptop3);

        selectLaptops();

        Laptop laptopToChange = new Laptop(2, "Lenovo", "Thinkpad X1", 75000);
        changeLaptop(laptopToChange );
        selectLaptops();

        deleteLaptop(3);

        selectLaptops();

    }

    public static Connection connection(){
        Connection connection = null;
        try {
            Class.forName(ConnectionData.DRIVER);
            connection = DriverManager.getConnection(ConnectionData.URL,
                    ConnectionData.USER, ConnectionData.PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void insertLaptop(Laptop laptop){
        String insert = "INSERT INTO "+TableColumnNames.LAPTOP_TABLE + "(" +
        TableColumnNames.LAPTOP_MANUFACTURER + "," + TableColumnNames.LAPTOP_MODEL + "," +
        TableColumnNames.LAPTOP_PRICE + ")" + "VALUES(?,?,?)";

        try {
            PreparedStatement pS = connection().prepareStatement(insert);
            pS.setString(1, laptop.getManufacturer());
            pS.setString(2, laptop.getModel());
            pS.setInt(3, laptop.getPrice());

            pS.executeUpdate();
            System.out.println(laptop.getManufacturer() + " "+laptop.getModel()+" was added to DB");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void selectLaptops() throws SQLException {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + TableColumnNames.LAPTOP_TABLE;

        try {
            PreparedStatement pS = connection().prepareStatement(select);
            resultSet = pS.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        while (resultSet.next()){
            Laptop laptop = new Laptop();
            laptop.setId(resultSet.getInt(1));
            laptop.setManufacturer(resultSet.getString(2));
            laptop.setModel(resultSet.getString(3));
            laptop.setPrice(resultSet.getInt(4));

            System.out.println(laptop);
        }
    }

    public static void changeLaptop(Laptop laptop){
        String change = "UPDATE " + TableColumnNames.LAPTOP_TABLE +
                " SET " + TableColumnNames.LAPTOP_MANUFACTURER + "=?" + "," +
                TableColumnNames.LAPTOP_MODEL + "=?" + "," +
                TableColumnNames.LAPTOP_PRICE + "=?" +
                " WHERE " + TableColumnNames.LAPTOP_ID + "=?";

        try {
            PreparedStatement pS = connection().prepareStatement(change);
            pS.setString(1, laptop.getManufacturer());
            pS.setString(2, laptop.getModel());
            pS.setInt(3, laptop.getPrice());
            pS.setInt(4, laptop.getId());

            pS.executeUpdate();
            System.out.println("Laptop " + laptop.getId() + " was successfully updated.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteLaptop(int id){
        String delete = "DELETE FROM " + TableColumnNames.LAPTOP_TABLE +
                " WHERE " + TableColumnNames.LAPTOP_ID + "=?";

        try {
            PreparedStatement pS = connection().prepareStatement(delete);
            pS.setInt(1, id);

            pS.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
