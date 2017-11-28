package com.reservation.model;

import java.util.List;

public interface ReservationDAO_interface {
	public void insert(ReservationVO reservationVO);
    public void update(ReservationVO reservationVO);
    public void delete(String res_no);
    public ReservationVO findByPrimaryKey(String res_no);
    public List<ReservationVO> getAll();
}
