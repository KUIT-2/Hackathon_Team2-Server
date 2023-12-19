package KUIT.CatchTable.Dao;

import KUIT.CatchTable.Dto.Reservation.GetReservationResponse;
import KUIT.CatchTable.Dto.Reservation.PostReservationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Repository
public class ReservationDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ReservationDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long createReservation(PostReservationRequest postReservationRequest) {
        String sql = "insert into Reservation(user_id, store_id, reservation_count, reservation_day, reservation_time) " + "values(:userId, :storeId, :reserveCount, :reserveDay, :reserveTime)";
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(postReservationRequest);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, parameterSource, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public boolean isFullResevation(long storeId, String reserveDay, String reserveTime, int reserveCount) {
        String sql = "select possible_people_number from store_possible_reservation_by_time where store_id=:storeId and day=:reserveDay and time=:reserveTime";
        Map<String, Object> param = Map.of(
                "storeId", storeId,
                "reserveDay", reserveDay,
                "reserveTime", reserveTime);
        int possible_people_number = jdbcTemplate.queryForObject(sql,param, Integer.class);
        if(possible_people_number-reserveCount < 0) return true;
        else{
            String updateSql = "update Store_possible_reservation_by_time set possible_people_number=:update_people_number where store_id=:store_id and day=:reserveDay and time=:reserveTime";
            Map<String, Object> updateParam = Map.of(
                    "update_people_number", (possible_people_number-reserveCount),
                    "store_id", storeId,
                    "reserveDay", reserveDay,
                    "reserveTime", reserveTime
            );
            jdbcTemplate.update(updateSql, updateParam);
            return false;
        }
    }

    public List<GetReservationResponse> getPossibleReservationTime(long storeId, String day, int reserveCount) {
        String sql = "select time from store_possible_reservation_by_time " +
                "where store_id=:storeId and day=:day and possible_people_number>=:reserveCount";
        Map<String, Object> param = Map.of(
                "storeId", storeId,
                "day", day,
                "reserveCount", reserveCount
        );

        return jdbcTemplate.query(sql, param,
                (rs, rowNum) -> new GetReservationResponse(rs.getString("time")));
    }
}
