package capitole.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import capitole.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer>, JpaSpecificationExecutor<Price> {
	
	@Query("SELECT p FROM Price p WHERE p.brandId = :brandId and p.productId= :productId "
			+ "and p.startDate < :date and p.endDate > : date order by priority desc, priceList desc")
	public List<Price> getPrices(@Param(value = "brandId") int brandId, @Param(value = "productId") int productId, @Param(value = "date") String date);
}
