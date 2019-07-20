package cj.api.model.benefit.coupon.criteria;


import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
public class ItemChannelCriteria implements Serializable {
	
	private static final long serialVersionUID = -859339950001868487L;
	
	private String itemCode;
	private Integer channelCode;
}
