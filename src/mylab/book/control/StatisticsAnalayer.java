package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalayer {
	public Map<String, Double> calculateAveragePriceByType(Publication[] publications){
		Map<String, double[]> stats = new HashMap<String, double[]>();
		
		for (Publication publication : publications) {
            String type = getPublicationType(publication);
            
            double[] stat = stats.getOrDefault(type, new double[]{0.0, 0.0});
            
            stat[0] += publication.getPrice(); // 총 가격 누적
            stat[1]++;                         // 개수 누적
            
            stats.put(type, stat);
            }
		
        Map<String, Double> averagePrices = new HashMap<>();
        for (Map.Entry<String, double[]> entry : stats.entrySet()) {
            String type = entry.getKey();
            double[] stat = entry.getValue();
            
            double totalPrice = stat[0];
            double count = stat[1];
            
            if (count > 0) {
                averagePrices.put(type, totalPrice / count);
            }
        }
        return averagePrices;
	}
	public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        int totalCount = publications.length;
        Map<String, Integer> typeCounts = new HashMap<>();
        
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            typeCounts.put(type, typeCounts.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distribution = new HashMap<>();
        for (Map.Entry<String, Integer> entry : typeCounts.entrySet()) {
            double percentage = (double) entry.getValue() / totalCount * 100;
            distribution.put(entry.getKey(), percentage);
        }
        return distribution;
    }
	
	public double calculatePublicationRatioByYear(Publication[] publications, String year) {
       int totalCount = publications.length;
       int matchingCount = 0;

       for (Publication pub : publications) {
           // 출판일자에서 연도 추출
           String publicationYear = pub.getPublishDate().substring(0, 4);
           if (publicationYear.equals(year)) {
               matchingCount++;
           }
       }

       return (double) matchingCount / totalCount * 100;
   }
		private String getPublicationType(Publication pub) {
	        if (pub instanceof Novel) {
	            return "소설";
	        } else if (pub instanceof Magazine) {
	            return "잡지";
	        } else if (pub instanceof ReferenceBook) {
	            return "참고서";
	        }
	        return "기타";
	    }
		public void printStatistics(Publication[] publications) {
	        DecimalFormat df = new DecimalFormat("#,##0.00");

	        System.out.println("====출판물 통계분석====");


	        // 1. 타입별 평균 가격
	        System.out.println("1.타입별 평균 가격");
	        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
	        for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
	            System.out.println(entry.getKey() + ": " + df.format(entry.getValue()) + "원");
	        }

	        // 2. 출판물 유형 분포
	        System.out.println("2.출판물 유형 분포");
	        Map<String, Double> distribution = calculatePublicationDistribution(publications);
	        for (Map.Entry<String, Double> entry : distribution.entrySet()) {
	            System.out.println(entry.getKey() + ": " + df.format(entry.getValue()) + "%");
	        }

	        // 3. 2007년도 출판물 비율
	        System.out.println("3. 2007년도 출판물 비율");
	        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
	        System.out.println("2007년 출판물 비율: " + df.format(ratio2007) + "%");
	        
	   }
}

