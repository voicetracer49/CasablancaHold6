
package DataSource;

public class ReservationMapper
{
//=== Maps between objects and tables
//=== Encapsulates SQL-statements

//    public Reservation getReservation(int reservarionID, Connection con)
//    {
//       
//    }

//    //== Insert new order (tuple)
//    public boolean saveNewReservation(Reservation res, Connection con)
//    {
//        int rowsInserted = 0;
//        String SQLString1 =
//                "select reservationseq.nextval from dual";
//        String SQLString2 =
//                "insert into tblReservation values (?,?,?,?,?)";
//        PreparedStatement statement = null;
//
//        try
//        {
//            //== get unique ono
//            statement = con.prepareStatement(SQLString1);
//            ResultSet rs = statement.executeQuery();
//            if (rs.next())
//            {
//                res.setOno(rs.getInt(1));
//            }
//
//            //== insert tuple
//            statement = con.prepareStatement(SQLString2);
//            statement.setInt(1, res.getOno());
//            statement.setInt(2, res.getCustomerNo());
//            statement.setInt(3, res.getEmployeeNo());
//            statement.setString(4, res.getReceived());
//            statement.setString(5, res.getShipped());
//            rowsInserted = statement.executeUpdate();
//        } catch (Exception e)
//        {
//            System.out.println("Fail in OrderMapper - saveNewReservation");
//            System.out.println(e.getMessage());
//        } finally // must close statement
//        {
//            try
//            {
//                statement.close();
//            } catch (SQLException e)
//            {
//                System.out.println("Fail in OrderMapper - saveNewreservation");
//                System.out.println(e.getMessage());
//            }
//        }
//        return rowsInserted == 1;
//    }
}
