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
            
            stat[0] += publication.getPrice(); // �� ���� ����
            stat[1]++;                         // ���� ����
            
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
           // �������ڿ��� ���� ����
           String publicationYear = pub.getPublishDate().substring(0, 4);
           if (publicationYear.equals(year)) {
               matchingCount++;
           }
       }

       return (double) matchingCount / totalCount * 100;
   }
		private String getPublicationType(Publication pub) {
	        if (pub instanceof Novel) {
	            return "�Ҽ�";
	        } else if (pub instanceof Magazine) {
	            return "����";
	        } else if (pub instanceof ReferenceBook) {
	            return "����";
	        }
	        return "��Ÿ";
	    }
		public void printStatistics(Publication[] publications) {
	        DecimalFormat df = new DecimalFormat("#,##0.00");

	        System.out.println("====���ǹ� ���м�====");


	        // 1. Ÿ�Ժ� ��� ����
	        System.out.println("1.Ÿ�Ժ� ��� ����");
	        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
	        for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
	            System.out.println(entry.getKey() + ": " + df.format(entry.getValue()) + "��");
	        }

	        // 2. ���ǹ� ���� ����
	        System.out.println("2.���ǹ� ���� ����");
	        Map<String, Double> distribution = calculatePublicationDistribution(publications);
	        for (Map.Entry<String, Double> entry : distribution.entrySet()) {
	            System.out.println(entry.getKey() + ": " + df.format(entry.getValue()) + "%");
	        }

	        // 3. 2007�⵵ ���ǹ� ����
	        System.out.println("3. 2007�⵵ ���ǹ� ����");
	        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
	        System.out.println("2007�� ���ǹ� ����: " + df.format(ratio2007) + "%");
	        
	   }
}

