package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.PurchaseHistory;
import com.sha.springbootbookseller.repository.IPurchaseHistoryRepository;
import com.sha.springbootbookseller.repository.projection.IPurchaseItem;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class PurchaseHistoryService implements IPurchaseHistory{

    private final IPurchaseHistoryRepository purchaseHistoryRepository;
    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public List<IPurchaseItem> findPurchasedItemsOfUser(Long userId){
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }

}
