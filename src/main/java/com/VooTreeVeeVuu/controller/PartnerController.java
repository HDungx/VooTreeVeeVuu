package com.VooTreeVeeVuu.controller;



import com.VooTreeVeeVuu.entity.Partner;
import com.VooTreeVeeVuu.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/partners")
public class PartnerController {
    @Autowired
    PartnerRepository partnerRepository;

    // Get all partners
    @GetMapping
    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }

    // Get partner by ID
    @GetMapping("/{id}")
    public ResponseEntity<Partner> getPartnerById(@PathVariable String id) {
        Optional<Partner> partner = partnerRepository.findById(id);
        if (partner.isPresent()) {
            return ResponseEntity.ok(partner.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new partner
    @PostMapping
    public Partner createPartner(@RequestBody Partner partner) {
        return partnerRepository.save(partner);
    }

    // Update a partner
    @PutMapping ("/update/{id}")
    public ResponseEntity<Partner> updatePartner(@PathVariable String id, @RequestBody Partner partners) {
        Optional<Partner> partner = partnerRepository.findById(id);
        if (partner.isPresent()) {
            Partner pn = partner.get();
            pn.setFirstName(partners.getFirstName());
            pn.setLastName(partners.getLastName());
            pn.setEmail(partners.getEmail());
            pn.setPhoneNum(partners.getPhoneNum());
            pn.setGender(partners.getGender());
            pn.setAge(partners.getAge());
            pn.setStatus(Partner.Partner_status.ACTIVE);
            Partner updatedPartner = partnerRepository.save(pn);
            return ResponseEntity.ok(updatedPartner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping ("/admin/update/{id}")
    public ResponseEntity<Partner> updateStatus(@PathVariable String id, @RequestBody Partner partners) {
        Optional<Partner> partner = partnerRepository.findById(id);
        if (partner.isPresent()) {
            Partner pn = partner.get();
            pn.setStatus(partners.getStatus());
            Partner updatedStatus = partnerRepository.save(pn);
            return ResponseEntity.ok(updatedStatus);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> deletePartner(@PathVariable String id) {
        Optional<Partner> partner = partnerRepository.findById(id);
        if (partner.isPresent()) {
            partnerRepository.delete(partner.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
