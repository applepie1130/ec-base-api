
package cj.api.controller.stock;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "재고 API")
@RestController
@RequestMapping("/v1/stock")
public class StockAPIContoller {
	
	@GetMapping( path="/realItemStock", produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(
			httpMethod = "GET",
			value = "실시간 상품코드기반 재고 조회",
			notes = "상품코드에 해당하는 각 단품의 재고수량정보 조회"
			)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "itemCode", value = "상품코드", required = true, dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "channelCode", value = "채널코드", required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "requestDate", value = "요청날짜 (String, format : yyyyMMddHHmmss)", required = true, dataType = "string", paramType = "query")
	})
	public Map<String, Object> getRealItemStock(
			@RequestParam(value="itemCode", defaultValue="") String itemCode,
			@RequestParam(value="channelCode", defaultValue="") String channelCode,
			@RequestParam(value="requestDate", defaultValue="") String requestDate
		) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("txId", "1234");
		paramMap.put("result", "1234");
		paramMap.put("code", 1);
		paramMap.put("message", "성공적으로 처리되었습니다.");
		
		return paramMap;
	}

}
