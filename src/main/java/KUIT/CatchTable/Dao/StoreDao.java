package KUIT.CatchTable.Dao;

import KUIT.CatchTable.Dto.store.GetCategoryStoreResponse;
import KUIT.CatchTable.Dto.store.GetDetailedStoreResponse;
import KUIT.CatchTable.Dto.store.GetFacilityStoreResponse;
import KUIT.CatchTable.Dto.store.GetMenuStoreResponse;
import KUIT.CatchTable.Dto.store.GetReviewStoreResponse;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class StoreDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public StoreDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public GetDetailedStoreResponse getDetailedStore(long storeId) {
        String sql =
                "select store.store_name, store.store_desc, store_image.store_image, avg(review.total_stars), count(review.total_stars), category.category_name, store.address "
                        + "from store join store_image on store.store_id = store_image.store_id "
                        + "join review on store.store_id = review.store_id "
                        + "join store.category_id = category.category_id "
                        + "where store_id = :storeId";
        Map<String, Object> param = Map.of("store_id", storeId);
        return jdbcTemplate.queryForObject(sql, param, GetDetailedStoreResponse.class);
    }

    public List<GetMenuStoreResponse> getMenuStore(long storeId) {
        String sql = "select menu_name, price "
                + "from menu "
                + "where store_id=:storeId";

        Map<String, Object> param = Map.of("store_id", storeId);
        return jdbcTemplate.query(sql, param,
                (rs, rowNum) -> new GetMenuStoreResponse(
                        rs.getString("menu_name"),
                        rs.getString("price")
                ));
    }

    public List<GetCategoryStoreResponse> getCategoryStore(long categoryId) {
        String sql =
                "select store.store_name, store.store_desc, store_image.store_image, avg(review.total_stars) as avg_score, count(review.total_stars) as total_score "
                        + "from store join store_image on store.store_id = store_image.store_id "
                        + "join review on store.store_id = review.store_id "
                        + "where store.category_id = :categoryId";
        Map<String, Object> param = Map.of("categoryId", categoryId);
        return jdbcTemplate.query(sql, param,
                (rs, rowNum) -> new GetCategoryStoreResponse(
                        rs.getString("store_image"),
                        rs.getString("store_name"),
                        rs.getString("store_desc"),
                        rs.getFloat("avg_score"),
                        rs.getInt("total_score")
                ));
    }

    public List<GetCategoryStoreResponse> getHotplaceStore() {
        String sql =
                "select store.store_name, store.store_desc, store_image.store_image, avg(review.total_score) as avg_score, count(review.total_stars) as total_score "
                        + "from store join store_image on store.store_id = store_image.store_id "
                        + "join review on store.store_id = review.store_id "
                        + "where store.hot_place = true";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new GetCategoryStoreResponse(
                rs.getString("store_image"),
                rs.getString("store_name"),
                rs.getString("store_desc"),
                rs.getFloat("avg_score"),
                rs.getInt("total_score")
        ));
    }

    public List<GetReviewStoreResponse> getReviewStore(long storeId) {
        String sql =
                "select user.name, review.total_stars, review.created_at, review.review_image, review.review "
                        + "from review join user on review.user_id = user.user_id "
                        + "join review_image on review.review_id = review_image.review_id "
                        + "where review.store_id = :storeId";
        Map<String, Object> param = Map.of("storeId", storeId);
        return jdbcTemplate.query(sql, param,
                (rs, rowNum) -> new GetReviewStoreResponse(
                        rs.getString("name"),
                        rs.getFloat("total_stars"),
                        rs.getString("created_at"),
                        rs.getString("review_image"),
                        rs.getString("review")
                ));
    }
}
