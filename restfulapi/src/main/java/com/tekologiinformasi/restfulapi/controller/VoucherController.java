package com.tekologiinformasi.restfulapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tekologiinformasi.restfulapi.model.Voucher;
import com.tekologiinformasi.restfulapi.service.VoucherService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*") // Tambahkan agar bisa diakses dari frontend
@RestController
@RequestMapping("/api/voucher")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    // Endpoint untuk mengambil semua voucher
    @GetMapping
    public ResponseEntity<List<Voucher>> getAllVoucher() {
        List<Voucher> vouchers = voucherService.getAllVoucher();
        return ResponseEntity.ok(vouchers);
    }

    // Endpoint untuk mengambil voucher berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<Voucher> getVoucherById(@PathVariable Long id) {
        Optional<Voucher> voucher = voucherService.getVoucherById(id);
        return voucher.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Endpoint untuk membuat voucher baru
    @PostMapping
    public ResponseEntity<Voucher> createVoucher(@RequestBody Voucher voucher) {
        Voucher newVoucher = voucherService.createVoucher(voucher);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVoucher);
    }

    // Endpoint untuk mengupdate voucher yang sudah ada
    @PutMapping("/{id}")
    public ResponseEntity<Voucher> updateVoucher(@PathVariable Long id, @RequestBody Voucher voucherDetails) {
        try {
            Voucher updatedVoucher = voucherService.updateVoucher(id, voucherDetails);
            return ResponseEntity.ok(updatedVoucher);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Endpoint untuk menghapus voucher
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteVoucher(@PathVariable Long id) {
        try {
            voucherService.deleteVoucher(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Voucher berhasil dihapus");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Voucher tidak ditemukan dengan id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
