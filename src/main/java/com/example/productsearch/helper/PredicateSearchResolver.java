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
    Predicate<MobileHandSet> predicate= null;
    List<Predicate<MobileHandSet>> predicates = new ArrayList<>();

    public List<Predicate<MobileHandSet>> resolve(SearchCriteriaMobileHandset searchHandSetCriteria){

        log.info("start PredicateSearchResolver :: resolve ");

        if (null != searchHandSetCriteria.getPriceEur() || null != searchHandSetCriteria.getPrice()) {
            predicate= h -> h.getRelease().getPriceEur() .equals(null != searchHandSetCriteria.getPriceEur() ? searchHandSetCriteria.getPriceEur(): searchHandSetCriteria.getPrice());
            predicates.add(predicate);
        }
        if (null != searchHandSetCriteria.getSim()) {
            predicate= h -> null != h && h.getSim().toLowerCase(Locale.ROOT).contains(searchHandSetCriteria.getSim().toLowerCase(Locale.ROOT));
            predicates.add(predicate);
        }
        if (null != searchHandSetCriteria.getAnnounceDate()) {
            predicate= h -> null != h.getRelease() && h.getRelease().getAnnounceDate().equalsIgnoreCase(searchHandSetCriteria.getAnnounceDate());
            predicates.add(predicate);
        }
        if (null != searchHandSetCriteria.getBattery()) {
            predicate= h -> null != h.getHardware() && h.getHardware().getBattery().equalsIgnoreCase(searchHandSetCriteria.getBattery());
            predicates.add(predicate);
        }
        if (null != searchHandSetCriteria.getGps()) {
            predicate= h -> null != h.getHardware() && h.getHardware().getGps().equalsIgnoreCase(searchHandSetCriteria.getGps());
            predicates.add(predicate);
        }

        if (null != searchHandSetCriteria.getAudioJack()) {
            predicate= h -> null != h.getHardware() && h.getHardware().getAudioJack().equalsIgnoreCase(searchHandSetCriteria.getAudioJack());
            predicates.add(predicate);
        }

        if (null != searchHandSetCriteria.getBrand()) {
            predicate= h -> null != h && h.getBrand().equalsIgnoreCase(searchHandSetCriteria.getBrand());
            predicates.add(predicate);
        }
        if (null != searchHandSetCriteria.getPhone()) {
            predicate= h -> null != h && h.getPhone().equalsIgnoreCase(searchHandSetCriteria.getPhone());
            predicates.add(predicate);
        }
        if (null != searchHandSetCriteria.getResolution()) {
            predicate= h -> null != h && h.getResolution().equalsIgnoreCase(searchHandSetCriteria.getResolution());
            predicates.add(predicate);
        }
        if (null != searchHandSetCriteria.getPicture()) {
            predicate= h -> null != h && h.getPicture().equalsIgnoreCase(searchHandSetCriteria.getPicture());
            predicates.add(predicate);
        }
        if (0 != searchHandSetCriteria.getId()) {
            predicate= h -> null != h && h.getId() == searchHandSetCriteria.getId();
            predicates.add(predicate);
        }
        log.info("start PredicateSearchResolver :: resolve ");
        return predicates;
    }
}
