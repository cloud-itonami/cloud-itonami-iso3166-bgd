(ns culture.facts
  "Country-level regional-culture catalog for Bangladesh (BGD) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"BGD"
   [{:culture/id "bgd.dish.panta-bhat"
     :culture/name "Panta bhat"
     :culture/name-local "পান্তা ভাত"
     :culture/country "BGD"
     :culture/kind :dish
     :culture/summary "Cooked rice soaked and fermented in water; panta bhat with ilish (hilsa) is the national dish of Bangladesh and part of Pahela Baishakh festivities."
     :culture/url "https://en.wikipedia.org/wiki/Panta_bhat"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bgd.dish.shorshe-ilish"
     :culture/name "Shorshe ilish"
     :culture/country "BGD"
     :culture/kind :dish
     :culture/summary "Bengali dish of hilsa fish cooked in mustard gravy, widely considered the national dish of Bangladesh."
     :culture/url "https://en.wikipedia.org/wiki/Shorshe_ilish"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bgd.dish.pitha"
     :culture/name "Pitha"
     :culture/country "BGD"
     :culture/kind :dish
     :culture/summary "Sweet or savoury foods similar to pancakes, dumplings or fritters, made from rice- or wheat-flour dough or batter; especially popular in Bangladesh and eastern India."
     :culture/url "https://en.wikipedia.org/wiki/Pitha"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bgd.beverage.borhani"
     :culture/name "Borhani"
     :culture/country "BGD"
     :culture/kind :beverage
     :culture/summary "Traditional yogurt-based drink from Bangladesh, commonly consumed in the Dhaka and Chittagong regions at weddings and Ramadan iftar meals."
     :culture/url "https://en.wikipedia.org/wiki/Borhani"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bgd.craft.jamdani"
     :culture/name "Jamdani"
     :culture/country "BGD"
     :culture/kind :craft
     :culture/summary "Fine figured muslin textile woven for centuries in Narayanganj district, Bangladesh; the art of jamdani weaving was declared a UNESCO Intangible Cultural Heritage of Humanity in 2013."
     :culture/url "https://en.wikipedia.org/wiki/Jamdani"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bgd.craft.nakshi-kantha"
     :culture/name "Nakshi kantha"
     :culture/country "BGD"
     :culture/kind :craft
     :culture/summary "Centuries-old Bengali embroidered-quilt art made from old cloth and thread using the running kantha stitch, made throughout Bangladesh."
     :culture/url "https://en.wikipedia.org/wiki/Nakshi_kantha"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bgd.festival.pohela-boishakh"
     :culture/name "Pohela Boishakh"
     :culture/name-local "পহেলা বৈশাখ"
     :culture/country "BGD"
     :culture/kind :festival
     :culture/summary "Bengali New Year festival, celebrated in Bangladesh on 14 April with processions, fairs and family time; its Mangal Shobhajatra procession was recognised by UNESCO as Intangible Cultural Heritage in 2016."
     :culture/url "https://en.wikipedia.org/wiki/Pohela_Boishakh"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bgd.heritage.somapura-mahavihara"
     :culture/name "Somapura Mahavihara"
     :culture/country "BGD"
     :culture/kind :heritage
     :culture/summary "Major Buddhist mahavihara of the Pala period in Paharpur, Naogaon District, Bangladesh, designated a UNESCO World Heritage Site in 1985."
     :culture/url "https://en.wikipedia.org/wiki/Somapura_Mahavihara"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-bgd culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "BGD"))
                 " BGD entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
