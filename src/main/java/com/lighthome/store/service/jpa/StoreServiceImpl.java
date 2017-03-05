package com.lighthome.store.service.jpa;

import java.util.List;

import javax.persistence.*;

import org.apache.commons.logging.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.Cacheable;
import com.lighthome.store.domain.*;
import com.lighthome.store.service.StoreService;


@Service("jpaItemsCategoryService")
@Repository
@Transactional
public class StoreServiceImpl implements StoreService {
	
	private Log log = LogFactory.getLog(StoreServiceImpl.class);
	
	final static String GET_BRANDS_BY_NUMBER = "SELECT B.NAME, B.ID, COUNT(*) as COUNT FROM BRAND B RIGHT JOIN ITEMS I ON B.ID = I.BRAND_ID WHERE I.CATEGORY_ID = 9323440067 GROUP BY B.ID";
	final static String GET_BRANDS_BY_CATEGORY_ID = "SELECT B.NAME, B.ID, COUNT(*) as COUNT FROM BRAND B RIGHT JOIN ITEMS I ON B.ID = I.BRAND_ID WHERE I.CATEGORY_ID = ?1 GROUP BY B.ID"; 
	final static String GET_ITEMS_BY_CATEGORY_ID_AND_BRAND_ID = "Select * from ITEMS WHERE ITEMS.CATEGORY_ID=?1 AND ITEMS.BRAND_ID=?2 AND ITEMS.ENABLE=true";
	final static String GET_BRAND_DESCRIPTION_BY_BRAND_ID = "Select B.DESCRIPTION FROM BRAND B WHERE ID=?1";
	
	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	@Transactional(readOnly=true)
	@Cacheable(cacheName = "categoriesCache")
	public List<ItemsCategory> findAll() {
		List<ItemsCategory> itemsCategory = entityManager.createNamedQuery("ItemsCategory.findAll",
				ItemsCategory.class ).getResultList();
	    
		return itemsCategory;
	}

	@Override
	public ItemsCategory findByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(ItemsCategory itemsCategory) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ItemsCategory itemsCategory) {
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional(readOnly=true)
	@Cacheable(cacheName = "brandsCache")
	public List<BrandInfo> getBrandsByCategoryID(Long categoryId) {
	
		//List<Brand> result = entityManager.createNamedQuery("Brands.getBrandsByCategoryId", Brand.class).setParameter("CATEGORY_ID", categoryId).getResultList();
		@SuppressWarnings("unchecked")
		List<BrandInfo> result = entityManager.createNativeQuery(GET_BRANDS_BY_CATEGORY_ID, "BrandInfoMapping").setParameter(1, categoryId).getResultList();
		return result;
	}

	@Override
	@Transactional(readOnly=true)
	@Cacheable(cacheName = "itemsCache")
	public List<Items> getItemsByCategoryIdAndBrandId(Long categoryId,
			Long brandId) {	
	
		@SuppressWarnings("unchecked")
		List<Items> result = entityManager.createNativeQuery(GET_ITEMS_BY_CATEGORY_ID_AND_BRAND_ID, Items.class).setParameter(1, categoryId).setParameter(2, brandId).getResultList();
		//List<Items> result = entityManager.createNamedQuery("Items.getItemsByCategoryIdAndBrandId", Items.class).setParameter("cid", categoryId).setParameter("bid", brandId).getResultList();
		
		return result;
	}

	@Override
	@Cacheable(cacheName = "brandDescriptionCache")
	@Transactional(readOnly=true)
	public String getBrandDescriptionByBrandId(Long id) {
		
		String description = entityManager.createNativeQuery(GET_BRAND_DESCRIPTION_BY_BRAND_ID).setParameter(1, id).getSingleResult().toString();
		return description;
	}

}
