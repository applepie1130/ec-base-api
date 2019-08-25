
package cj.api.controller.benefit.coupon;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cj.api.model.benefit.coupon.tuple.CouponTuple;
import cj.api.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "쿠폰 API")
@RestController
@RequestMapping("/v1/benefit/coupon")
public class CouponAPIContoller {
	
	@Autowired
	private TestService testService;
	
	@GetMapping( path="/item", produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(
			httpMethod = "GET",
			value = "실시간 공개쿠폰 조회",
			notes = "상품적용가능 공개쿠폰 중 일반, 쇼핑플러스 쿠폰 대상 조회",
			response = CouponTuple.class
			)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "itemCode", value = "상품코드", required = true, dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "channelCode", value = "채널코드", required = true, dataType = "int", paramType = "query")
	})
	public CouponTuple getItemCoupon (
			@RequestParam(value="itemCode", defaultValue = "") String itemCode,
			@RequestParam(value="channelCode", defaultValue = "") Integer channelCode
		) {
		
		testService.getService();
		
		
		CouponTuple couponTuple = CouponTuple.builder()	
		.offerCode("R19052116LL82930")
		.offerName("★텐바이텐 5% 쿠폰_M")
		.channelCode(50001001)
		.dcAmount(BigDecimal.ZERO)
		.dcRate(5)
		.dcClsCode("2")
		.maxDcAmount(BigDecimal.ZERO)
		.duplicationYn("0")
		.minMarginRate(BigDecimal.ZERO)
		.spItemObjYn("1")
		.build();
		
		return couponTuple;
	}

}
