(ns statute.facts
  "General-law compliance catalog for Bangladesh (BGD) -- extends this
  repo's existing `marketentry.facts` (public-procurement / e-GP
  market-entry scope) with a second, orthogonal catalog of national
  statutes an operator generally must track for compliance. Mirrors
  cloud-itonami-iso3166-ind/-lka/-npl's `statute.facts` (ADR-2607141700,
  cloud-itonami-compliance-fact-federation).

  `marketentry.facts` already establishes RJSC (Registrar of Joint Stock
  Companies and Firms) and NBR (National Board of Revenue) as BGD's
  company-registration/TIN authorities via
  `corporate-number-owner-authority` \"RJSC / NBR\" / `corporate-number-
  legal-basis` \"Company registration / TIN\". This catalog does not
  duplicate or contradict that entry -- it extends it with the actual Act
  names/numbers those two authorities administer, fetched and read
  directly this session.

  - **The Companies Act, 1994 (Act No. 18 of 1994)** -- RJSC's own
    official site (`roc.gov.bd/pages/laws`, fetched directly) lists
    'কোম্পানী আইন ১৯৯৪' ('Companies Act 1994') with `law_no` '18',
    published 12-09-1994 -- the Act RJSC itself administers, corroborating
    and extending `marketentry.facts`'s existing citation. Independently
    corroborated via the Ministry of Law, Justice and Parliamentary
    Affairs' own laws portal (`bdlaws.minlaw.gov.bd/act-788.html`), whose
    own page heading reads '১৯৯৪ সনের ১৮ নং আইন' ('Act No. 18 of the year
    1994') and whose own section-1 page states the Act's own preamble
    ('কোম্পানীসমূহ ও অন্যান্য কতিপয় সমিতি সম্পর্কিত আইন একীভূতকরণ ও
    সংশোধনকল্পে প্রণীত আইন' -- 'An Act made to consolidate and amend the
    law relating to companies and certain other associations'). HONEST
    GAP: the PDF RJSC's own site links from this same listing entry
    (`.../633f27...pdf`) was downloaded and read directly via
    `pdftotext`, but its own Gazette header identifies itself as an
    UNRELATED 2022 Trade Organisations Ordinance amendment (own text:
    '2022 সনের ০৯ নং আইন', 'Trade Organisations Ordinance, 1961 (Ordinance
    No. XLV of 1961)') -- a mismatched/broken upload on RJSC's own site,
    not this Act's actual text. This catalog therefore cites
    bdlaws.minlaw.gov.bd's verified-correct primary text as `:statute/url`
    rather than RJSC's own broken PDF link, while still crediting RJSC's
    own listing table (title/law-no/date columns, not the PDF binary) as
    independent corroboration of the Act No./date.

  - **The Bangladesh Labour Act, 2006 (Act No. 42 of 2006), as amended
    2013, 2018 and 2026** -- the Department of Inspection for Factories
    and Establishments' (DIFE, under the Ministry of Labour and
    Employment) own official 'laws' listing (`dife.gov.bd/pages/laws`,
    fetched directly) titles the base Act 'বাংলাদেশ শ্রম আইন-২০০৬',
    `law_no` '42', published 12-10-2006, own PDF fetched directly. HONEST
    GAP: that PDF is legacy-Bijoy-font-encoded (like several sibling
    repos' PDFs, e.g. `cloud-itonami-iso3166-npl`'s) -- this iteration
    did not independently OCR/decode its full body text this session.
    The SAME DIFE listing table also directly shows further amendments:
    'বাংলাদেশ শ্রম আইন-২০০৬ (সংশোধনী-২০১৩)' (Amendment 2013, `law_no` 42,
    published 22-07-2013) and 'বাংলাদেশ শ্রম আইন-২০০৬ (সংশোধনী-২০১৮)'
    (Amendment 2018, `law_no` 58, published 14-11-2018) -- matching this
    catalog family's own brief ('as amended 2013/2018') -- plus a THIRD,
    more recent amendment this iteration discovered by direct fetch
    rather than assumed from the brief: 'বাংলাদেশ শ্রম (সংশোধন) আইন,
    ২০২৬' (Labour (Amendment) Act, 2026, `law_no` 43, published
    17-05-2026). The amendment chain is therefore longer than the
    catalog-family brief anticipated.

  - **The Income Tax Act, 2023 (Act No. XII of 2023)** -- the National
    Board of Revenue's (NBR) own official Authentic English Text,
    published via S.R.O No. 404-Law/2025 (Bangladesh Gazette
    Extraordinary, 16 October 2025, itself made under s.345 of this
    Act), fetched directly from NBR's own site
    (`nbr.gov.bd/uploads/acts/Income_tax_act_2023.pdf` -- required a
    `Referer` header to avoid a plain hotlink-protection 403, NOT a
    bot-detection/CAPTCHA challenge) and read in full via `pdftotext`:
    own s.1 ('This Act may be called the Income-tax Act, 2023 ... It
    shall come into force at once'); own s.261(1)-(2) ('A person shall
    register himself as an assessee if he... The Board shall issue a
    Taxpayer's Identification Number (TIN) to the registered assessee')
    -- this is the statute `marketentry.facts`'s 'RJSC / NBR' / TIN
    citation is grounded in on the NBR side. Own preamble: 'An Act to
    make a new law upon repealing the Income-tax Ordinance, 1984'.
    Independently corroborated via `bdlaws.minlaw.gov.bd/act-1429.html`,
    whose own heading reads '২০২৩ সনের ১২ নং আইন' ('Act No. 12 of the
    year 2023'). HONEST GAP: this iteration did not independently
    confirm the exact original 2023 assent day/month, only the Act
    No./year and s.1's own 'comes into force at once' -- the S.R.O. date
    above is for the 2025 authentic-English-text republication, not the
    2023 original Bangla enactment.

  - **HONEST UPDATE, not a gap -- The Personal Data Protection Act, 2026
    (Act No. 63 of 2026)**: this catalog family's brief assumed
    Bangladesh has 'no comprehensive data-protection law in force' (a
    long-pending draft being the only prior signal) -- but a direct
    fetch this session of the ICT Division's own official 'laws' listing
    (`ictd.gov.bd/pages/laws`) shows 'ব্যক্তিগত উপাত্ত সুরক্ষা আইন, ২০২৬'
    ('Personal Data Protection Act, 2026') newly on that listing
    (15-04-2026), and its own linked Gazette PDF -- legacy-font-encoded,
    but its dates/numerals/English loanwords render legibly -- states in
    unambiguous terms: passed by Parliament and received the President's
    assent 27 Chaitra 1432 / 10 April 2026, 'Act No. 63 of the year
    2026'. Independently corroborated via
    `bdlaws.minlaw.gov.bd/act-1692.html`, whose own page heading likewise
    reads '২০২৬ সনের ৬৩ নং আইন'. This is a genuinely enacted Act (own
    Gazette text: Presidential assent, published for general
    information), not a draft/bill -- so the honest disclosure this
    catalog makes is the OPPOSITE of a gap: the commonly-assumed
    legislative gap has closed. HONEST GAP (narrower): this iteration
    confirmed enactment / Act No. / date from the Gazette PDF's own
    legible header, plus one legible English loanword the Act's own text
    uses ('Chief Data Officer', a role the Act establishes), but did NOT
    fully OCR/decode the rest of its legacy-font-encoded body text this
    session -- substantive obligations (lawful-basis grounds,
    cross-border-transfer rules, penalties, any commencement-by-
    notification clause) are NOT independently confirmed here.

  A law not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of statute entries. `:statute/url` + `:statute/law-number`
  are the citation the governor requires before any compliance-fact
  proposal referencing this law can commit."
  {"BGD"
   [{:statute/id "bgd.companies-act-1994"
     :statute/title "The Companies Act, 1994"
     :statute/jurisdiction "BGD"
     :statute/kind :law
     :statute/law-number "Act No. 18 of 1994 (bdlaws.minlaw.gov.bd's own heading: '১৯৯৪ সনের ১৮ নং আইন'); RJSC's own official laws listing (roc.gov.bd/pages/laws) independently lists this Act with the same law_no (18) and a 12-09-1994 publish date; administered by the Registrar of Joint Stock Companies and Firms (RJSC), extending marketentry.facts's existing 'RJSC / NBR' / 'Company registration / TIN' citation. HONEST NOTE: the PDF RJSC's own site links from this same listing entry was verified to be mismatched (an unrelated 2022 Trade Organisations Ordinance amendment gazette) -- this entry cites bdlaws.minlaw.gov.bd's own verified text instead, see namespace docstring"
     :statute/url "http://bdlaws.minlaw.gov.bd/act-788.html"
     :statute/url-provenance :official-bdlaws-minlaw-gov-bd
     :statute/enacted-date "1994-09-12"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "bgd.labour-act-2006"
     :statute/title "The Bangladesh Labour Act, 2006 (as amended 2013, 2018 and 2026)"
     :statute/jurisdiction "BGD"
     :statute/kind :law
     :statute/law-number "Act No. 42 of 2006 (base Act, 'বাংলাদেশ শ্রম আইন-২০০৬'); Amendment Act No. 42 of 2013 (22-07-2013); Amendment Act No. 58 of 2018 (14-11-2018); Amendment Act No. 43 of 2026 (17-05-2026) -- all four listed directly on DIFE's own official 'laws' table (title/law_no/publish_date columns); administered by the Department of Inspection for Factories and Establishments (DIFE), Ministry of Labour and Employment"
     :statute/url "https://dife.gov.bd/pages/laws"
     :statute/url-provenance :official-dife-gov-bd
     :statute/enacted-date "2006-10-12"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:labor}}
    {:statute/id "bgd.income-tax-act-2023"
     :statute/title "The Income Tax Act, 2023"
     :statute/jurisdiction "BGD"
     :statute/kind :law
     :statute/law-number "Act No. XII of 2023 (own s.1: 'This Act may be called the Income-tax Act, 2023'; own s.261(1)-(2) TIN-registration duty); administered by the National Board of Revenue (NBR), extending marketentry.facts's existing 'RJSC / NBR' / TIN citation; repeals the former Income-tax Ordinance, 1984 (own preamble). Independently corroborated via bdlaws.minlaw.gov.bd's own heading '২০২৩ সনের ১২ নং আইন'. HONEST NOTE: exact original 2023 assent day/month not independently confirmed this session (only Act No./year and s.1's own 'It shall come into force at once')"
     :statute/url "https://nbr.gov.bd/uploads/acts/Income_tax_act_2023.pdf"
     :statute/url-provenance :official-nbr-gov-bd
     :statute/enacted-date "2023 (exact day/month not independently confirmed this session; s.1(2) own text: 'It shall come into force at once')"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:tax}}
    {:statute/id "bgd.personal-data-protection-act-2026"
     :statute/title "The Personal Data Protection Act, 2026"
     :statute/jurisdiction "BGD"
     :statute/kind :law
     :statute/law-number "Act No. 63 of 2026 (own Gazette header: passed by Parliament and received the President's assent 27 Chaitra 1432 / 10 April 2026, 'Act No. 63 of the year 2026'); independently corroborated via bdlaws.minlaw.gov.bd's own heading '২০২৬ সনের ৬৩ নং আইন' and the ICT Division's (ictd.gov.bd) own 'laws' listing. HONEST UPDATE: this catalog family's brief assumed Bangladesh had no comprehensive data-protection law in force (a long-pending draft) -- this session's direct fetch shows that gap has closed via this 2026 Act. HONEST GAP: full substantive body text not independently OCR'd/decoded this session (legacy-font-encoded PDF); only enactment/Act-No/date and one legible loanword ('Chief Data Officer', a role the Act establishes) independently confirmed, see namespace docstring"
     :statute/url "http://bdlaws.minlaw.gov.bd/act-1692.html"
     :statute/url-provenance :official-bdlaws-minlaw-gov-bd
     :statute/enacted-date "2026-04-10"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:data-protection :privacy}}]})

(defn spec-basis
  "The jurisdiction's statute vector, or nil -- nil means NO spec-basis
  for that jurisdiction yet."
  [iso3]
  (get catalog iso3))

(defn coverage
  "Honest coverage report, same shape/discipline as `marketentry.facts/coverage`:
  never report a missing jurisdiction as covered."
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-bgd statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "BGD")) " BGD statutes seeded with an "
                 "official citation each. Extend "
                 "`statute.facts/catalog`, never fabricate a law-id or URL.")})))

(defn by-topic
  "Statutes for `iso3` tagged with `topic` (e.g. :tax, :labor, :data-protection)."
  [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
