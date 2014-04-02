/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataSource;

import Domain.Reservation;

/**
 *
 * @author Anders Kjær
 */
public interface ReservationMapperInterface {
    
    boolean saveReservation(Reservation r);
    
    
}

