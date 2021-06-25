package com.example.productsearch.helper;

import com.example.productsearch.dto.MobileHandSet;
import com.example.productsearch.dto.SearchCriteriaMobileHandset;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

/**
 * @author Ramesh.Yaleru on 6/24/2021
 */
@Component
@Slf4j
public class PredicateSearchResolver {

    public List<Predicate<MobileHandSet>> resolve(SearchCriteriaMobileHandset searchHandSetCriteria){
        log.info("start PredicateSearchResolver :: resolve ");

        Predicate<MobileHandSet> predicate;
        List<Predicate<MobileHandSet>> predicates = new ArrayList<>();

        if (null != searchHandSetCriteria.getPriceEur() || null != searchHandSetCriteria.getPrice()) {
            predicate= h -> h.getRelease().getPriceEur() .equals(null != searchHandSetCriteria.getPriceEur() ? searchHandSetCriteria.getPriceEur(): searchHandSetCriteria.getPrice());
            predicates.add(predicate);
        }
        if (null != searchHandSetCriteria.getSim()) {
            predicate= h -> null != h && h.getSim().toLowerCase(Locale.ROOT).contains(searchHandSetCriteria.getSim().toLowerCase(Locale.ROOT));
            predicates.add(predicate);
        }
        if (null != searchHandSetCriteria.getAnnounceDate()) {
            predicate= h -> null != h.getRelease() && h.getRelease().getAnnounceDate().contains(searchHandSetCriteria.getAnnounceDate());
            predicates.add(predicate);
        }
        if (null != searchHandSetCriteria.getBattery()) {
            predicate= h -> null != h.getHardware() && h.getHardware().getBattery().contains(searchHandSetCriteria.getBattery());
            predicates.add(predicate);
        }
        if (null != searchHandSetCriteria.getGps()) {
            predicate= h -> null != h.getHardware() && h.getHardware().getGps().contains(searchHandSetCriteria.getGps());
            predicates.add(predicate);
        }

        if (null != searchHandSetCriteria.getAudioJack()) {
            predicate= h -> null != h.getHardware() && h.getHardware().getAudioJack().contains(searchHandSetCriteria.getAudioJack());
            predicates.add(predicate);
        }

        if (null != searchHandSetCriteria.getBrand()) {
            predicate= h -> null != h && h.getBrand().contains(searchHandSetCriteria.getBrand());
            predicates.add(predicate);
        }
        if (null != searchHandSetCriteria.getPhone()) {
            predicate= h -> null != h && h.getPhone().contains(searchHandSetCriteria.getPhone());
            predicates.add(predicate);
        }
        if (null != searchHandSetCriteria.getResolution()) {
            predicate= h -> null != h && h.getResolution().contains(searchHandSetCriteria.getResolution());
            predicates.add(predicate);
        }
        if (null != searchHandSetCriteria.getPicture()) {
            predicate= h -> null != h && h.getPicture().contains(searchHandSetCriteria.getPicture());
            predicates.add(predicate);
        }
        if (null != searchHandSetCriteria.getId()) {
            predicate= h -> null != h && h.getId().equals(searchHandSetCriteria.getId());
            predicates.add(predicate);
        }
        log.info("end PredicateSearchResolver :: resolve  with predicates ={}",predicates);
        return predicates;
    }
}
