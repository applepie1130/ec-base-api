package cj;

import java.util.List;
import java.util.Set;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

public class IntersectionTest {
	
	/**
	 * 교집합이 데이터 리스트 조회
	 * 교집합 데이터가 없을 경우 null return 
	 * 
	 * @param orderSheetUnitList
	 * @return
	 */
	private Set<String> getIntersectionSet(List<Set<String>> orderSheetUnitList) {
		Set<String> intersectionSet = Sets.newHashSet();
		int size = orderSheetUnitList.size();
		for ( int i = 0; i<size-1; i++ ) {
			if ( i == 0 ) {
				intersectionSet.addAll(orderSheetUnitList.get(i));
			}
			intersectionSet.retainAll(orderSheetUnitList.get(i+1));
		}
		
		if ( CollectionUtils.isEmpty(intersectionSet) ) {
			return null;
		}
		
		return intersectionSet;
	}

	@Test
	public void intersectionTest1() {
		// 주문서 단품리스트
		List<Set<String>> orderSheetUnitList = Lists.newArrayList();

		// 첫번째 단품의 배송예정일
		Set<String> unit1 = Sets.newHashSet();
		unit1.add("20190701");
		unit1.add("20190702");
		unit1.add("20190703");
		unit1.add("20190704");
		unit1.add("20190705");

		// 두번째 단품의 배송예정일
		Set<String> unit2 = Sets.newHashSet();
		unit2.add("20190702");
		unit2.add("20190703");
		unit2.add("20190704");
		unit2.add("20190705");
		unit2.add("20190706");

		// 세번째 단품의 배송예정일
		Set<String> unit3 = Sets.newHashSet();
		unit3.add("20190701");
		unit3.add("20190702");
		unit3.add("20190703");
		unit3.add("20190705");
		unit3.add("20190707");
		unit3.add("20190709");
		unit3.add("20190710");

		orderSheetUnitList.add(unit1);
		orderSheetUnitList.add(unit2);
		orderSheetUnitList.add(unit3);

		/**
		 * >> 기대결과 교집합 배송예정일 : 20190702, 20190703, 20190705
		 */
		System.out.println("############# 교집합 결과 ##############");
		System.out.println(this.getIntersectionSet(orderSheetUnitList));
		System.out.println("############# 교집합 결과 ##############");
	}
	
	@Test
	public void intersectionTest2() {
		// 주문서 단품리스트
		List<Set<String>> orderSheetUnitList = Lists.newArrayList();

		// 첫번째 단품의 배송예정일
		Set<String> unit1 = Sets.newHashSet();
		unit1.add("20190704");
		unit1.add("20190705");

		// 두번째 단품의 배송예정일
		Set<String> unit2 = Sets.newHashSet();
		unit2.add("20190703");
		unit2.add("20190704");
		unit2.add("20190706");

		// 세번째 단품의 배송예정일
		Set<String> unit3 = Sets.newHashSet();
		unit3.add("20190703");
		unit3.add("20190704");
		unit3.add("20190705");
		unit3.add("20190707");

		orderSheetUnitList.add(unit1);
		orderSheetUnitList.add(unit2);
		orderSheetUnitList.add(unit3);

		/**
		 * >> 기대결과 교집합 배송예정일 : 20190704
		 */
		System.out.println("############# 교집합 결과 ##############");
		System.out.println(this.getIntersectionSet(orderSheetUnitList));
		System.out.println("############# 교집합 결과 ##############");
	}
	
	@Test
	public void intersectionTest3() {
		// 주문서 단품리스트
		List<Set<String>> orderSheetUnitList = Lists.newArrayList();

		// 첫번째 단품의 배송예정일
		Set<String> unit1 = Sets.newHashSet();
		unit1.add("20190704");
		unit1.add("20190705");
		unit1.add("20190706");
		unit1.add("20190707");
		unit1.add("20190708");

		// 두번째 단품의 배송예정일
		Set<String> unit2 = Sets.newHashSet();
		unit2.add("20190709");
		unit2.add("20190710");
		unit2.add("20190711");

		// 세번째 단품의 배송예정일
		Set<String> unit3 = Sets.newHashSet();
		unit3.add("20190701");
		unit3.add("20190702");
		unit3.add("20190703");

		orderSheetUnitList.add(unit1);
		orderSheetUnitList.add(unit2);
		orderSheetUnitList.add(unit3);

		/**
		 * >> 기대결과 교집합 배송예정일 : null
		 */
		System.out.println("############# 교집합 결과 ##############");
		System.out.println(this.getIntersectionSet(orderSheetUnitList));
		System.out.println("############# 교집합 결과 ##############");
	}
	

}
