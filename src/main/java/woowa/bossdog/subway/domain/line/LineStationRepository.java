package woowa.bossdog.subway.domain.line;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineStationRepository extends JpaRepository<LineStation, Long> {
    List<LineStation> findAllByLineId(Long lineId);
}

