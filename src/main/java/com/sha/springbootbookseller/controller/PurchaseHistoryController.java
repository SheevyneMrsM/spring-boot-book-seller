package com.sha.springbootbookseller.controller;

import com.sha.springbootbookseller.model.PurchaseHistory;
import com.sha.springbootbookseller.model.User;
import com.sha.springbootbookseller.service.IPurchaseHistory;
import com.sha.springbootbookseller.service.PurchaseHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PurchaseHistoryController {


    private final PurchaseHistoryService purchaseHistoryService;

    public ResponseEntity<?> savePurchaseHistory(@RequestBody PurchaseHistory purchaseHistory){
        return new ResponseEntity<>(purchaseHistoryService.savePurchaseHistory(purchaseHistory), HttpStatus.OK);
    }
   @GetMapping
    public ResponseEntity<?> getAllPurchaseOfUser(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(purchaseHistoryService.findPurchasedItemsOfUser(user.getId()));
    }


}
