package cj.api.model.benefit.coupon.tuple;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value="CouponTuple", description="쿠폰정보")
public class CouponTuple implements Serializable {

	private static final long serialVersionUID = 5557124265353094647L;
	
	@ApiModelProperty(notes = "오퍼코드", name = "offerCode", required = true)
	private String offerCode;

	@ApiModelProperty(notes = "오퍼명", name = "offerName", required = true)
	private String offerName;
	
	@ApiModelProperty(notes = "채널코드" , name = "channelCode", required = true)
	private Integer channelCode;
	
	@ApiModelProperty(notes = "중복쿠폰여부 (0:일반쿠폰, 1:쇼핑플러스, 2:쇼핑지원금, 3:배송비쿠폰)", name = "duplicationYn", required = true)
	private String duplicationYn;
	
	@ApiModelProperty(notes = "할인구분 (1:정액 2:정률)", name = "dcClsCode", required = true)
	private String dcClsCode;
	
	@ApiModelProperty(notes = "할인율", name = "dcRate", required = true)
	private Integer dcRate;
	
	@ApiModelProperty(notes = "할인금액", name = "dcAmount", required = true)
	private BigDecimal dcAmount;
	
	@ApiModelProperty(notes = "최대할인금액", name = "maxDcAmount", required = true)
	private BigDecimal maxDcAmount;
	
	@ApiModelProperty(notes = "적용대상여부", name = "spItemObjYn", required = false)
	private String spItemObjYn;
	
	@ApiModelProperty(notes = "오퍼최소마진율", name = "minMarginRate", required = true)
	private BigDecimal minMarginRate;
}
