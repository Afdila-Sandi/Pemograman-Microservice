package com.tekologiinformasi.restfulapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekologiinformasi.restfulapi.model.Voucher;
import com.tekologiinformasi.restfulapi.repository.VoucherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    public List<Voucher> getAllVoucher() {
        return voucherRepository.findAll();
    }

    public Optional<Voucher> getVoucherById(Long id) {
        return voucherRepository.findById(id);
    }

    public Voucher createVoucher(Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    public Voucher updateVoucher(Long id, Voucher voucherDetails) {
        Voucher voucher = voucherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Voucher tidak ditemukan dengan id " + id));
        voucher.setKodeVoucher(voucherDetails.getKodeVoucher());
        voucher.setDiskon(voucherDetails.getDiskon());
        voucher.setDeskripsi(voucherDetails.getDeskripsi());
        return voucherRepository.save(voucher);
    }

    public void deleteVoucher(Long id) {
        Voucher voucher = voucherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Voucher tidak ditemukan dengan id " + id));
        voucherRepository.delete(voucher);
    }
}
