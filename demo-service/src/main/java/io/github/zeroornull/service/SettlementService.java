package io.github.zeroornull.service;



import com.demo.support.dto.SettlementOrderDTO;
import io.github.zeroornull.exception.BizException;
import io.github.zeroornull.model.SettlementInitDTO;
import io.github.zeroornull.model.SettlementSubmitDTO;

import java.util.Map;

public interface SettlementService {

    SettlementInitDTO initData(String productId,String buyNum) throws BizException;

    Map<String,Object> dependency();

    SettlementSubmitDTO submitOrder(SettlementOrderDTO requestDTO) throws BizException;

}
