# cloud-itonami-iso3166-bgd

**`:implemented`** for **BGD**. Flagship `bd-entity-missing`, tax `tin-unverified`.

```
kbb -M:dev:test
```

AGPL-3.0-or-later.

## Statute catalog

Alongside `src/marketentry/facts.kotoba` (public-procurement / e-GP
market-entry scope), this repo carries `src/statute/facts.kotoba` — a
second, orthogonal catalog of general national statutes an operator
must track for ongoing compliance (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`), mirroring
`cloud-itonami-iso3166-ind`/`-lka`/`-npl`'s `statute.facts`:

- `src/statute/facts.kotoba` — the catalog: The Companies Act, 1994 (Act
  No. 18 of 1994, RJSC — extends `marketentry.facts`'s existing "RJSC /
  NBR" citation), the Bangladesh Labour Act, 2006 as amended 2013/2018/
  2026 (DIFE, Ministry of Labour and Employment), the Income Tax Act,
  2023 (Act No. XII of 2023, NBR — repeals the former Income-tax
  Ordinance, 1984), and the Personal Data Protection Act, 2026 (Act No.
  63 of 2026) — an honest update to a commonly-assumed legislative gap:
  Bangladesh did not have a comprehensive data-protection law in force
  until this 2026 Act.
- `schema/statute.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data.

Same provenance discipline as `marketentry.facts`: every entry cites an
official government source actually fetched and read on
`:statute/retrieved-at`, with honest gaps/notes disclosed in the
namespace docstring rather than papered over. An item not in
`statute.facts/catalog` has no spec-basis — never fabricate one.

## Culture catalog

Alongside the market-entry / statute catalogs, this repo carries a
**country-level regional-culture catalog** (ADR-2607171400 addendum 2,
`cloud-itonami-municipality-culture-catalog` Wave 1, in
`com-junkawasaki/root`) — national dishes, protected products, beverages,
crafts, festivals and heritage sites for Bangladesh:

- `src/culture/facts.kotoba` — the catalog, source of truth (keyed by
  uppercase ISO3, mirroring `statute.facts`).
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

City-level counterparts live in the `cloud-itonami-municipality-*` repos.
Same provenance discipline as the compliance catalogs: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.
