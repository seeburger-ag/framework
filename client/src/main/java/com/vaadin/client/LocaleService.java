/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.vaadin.shared.ui.ui.UIState.LocaleData;

/**
 * Date / time etc. localisation service for all widgets. Caches all loaded
 * locales as JSONObjects.
 *
 * @author Vaadin Ltd.
 *
 */
public class LocaleService {

    private static Map<String, LocaleData> cache = new HashMap<String, LocaleData>();

    private static String defaultLocale;

    public static void addLocale(LocaleData localeData) {
        final String key = localeData.name;
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
        getLogger().fine("Received locale data for " + localeData.name);
        cache.put(key, localeData);
        if (cache.size() == 1) {
            setDefaultLocale(key);
        }
    }

    public static void setDefaultLocale(String locale) {
        defaultLocale = locale;
    }

    public static String getDefaultLocale() {
        return defaultLocale;
    }

    public static Set<String> getAvailableLocales() {
        return cache.keySet();
    }

    public static String[] getMonthNames(String locale)
            throws LocaleNotLoadedException {
        if (cache.containsKey(locale)) {
            return cache.get(locale).monthNames;
        } else {
            throw new LocaleNotLoadedException(locale);
        }
    }

    public static String[] getShortMonthNames(String locale)
            throws LocaleNotLoadedException {
        if (cache.containsKey(locale)) {
            return cache.get(locale).shortMonthNames;
        } else {
            throw new LocaleNotLoadedException(locale);
        }
    }

    public static String[] getDayNames(String locale)
            throws LocaleNotLoadedException {
        if (cache.containsKey(locale)) {
            return cache.get(locale).dayNames;
        } else {
            throw new LocaleNotLoadedException(locale);
        }
    }

    public static String[] getShortDayNames(String locale)
            throws LocaleNotLoadedException {
        if (cache.containsKey(locale)) {
            return cache.get(locale).shortDayNames;
        } else {
            throw new LocaleNotLoadedException(locale);
        }
    }

    public static int getFirstDayOfWeek(String locale)
            throws LocaleNotLoadedException {
        if (cache.containsKey(locale)) {
            return cache.get(locale).firstDayOfWeek;
        } else {
            throw new LocaleNotLoadedException(locale);
        }
    }

    public static String getDateFormat(String locale)
            throws LocaleNotLoadedException {
        if (cache.containsKey(locale)) {
            return cache.get(locale).dateFormat;
        } else {
            throw new LocaleNotLoadedException(locale);
        }
    }

    public static boolean isTwelveHourClock(String locale)
            throws LocaleNotLoadedException {
        if (cache.containsKey(locale)) {
            return cache.get(locale).twelveHourClock;
        } else {
            throw new LocaleNotLoadedException(locale);
        }
    }

    public static String getClockDelimiter(String locale)
            throws LocaleNotLoadedException {
        if (cache.containsKey(locale)) {
            return cache.get(locale).hourMinuteDelimiter;
        } else {
            throw new LocaleNotLoadedException(locale);
        }
    }

    public static String[] getAmPmStrings(String locale)
            throws LocaleNotLoadedException {
        if (cache.containsKey(locale)) {
            return new String[] { cache.get(locale).am, cache.get(locale).pm };
        } else {
            throw new LocaleNotLoadedException(locale);
        }
    }

    public static void addLocales(List<LocaleData> localeDatas) {
        for (LocaleData localeData : localeDatas) {
            addLocale(localeData);
        }
    }

    private static Logger getLogger() {
        return Logger.getLogger(LocaleService.class.getName());
    }
}
