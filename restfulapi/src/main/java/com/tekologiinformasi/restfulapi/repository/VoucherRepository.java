package com.tekologiinformasi.restfulapi.repository;

import com.tekologiinformasi.restfulapi.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {
}
