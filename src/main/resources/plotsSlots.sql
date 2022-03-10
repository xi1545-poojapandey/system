CREATE TABLE IF NOT EXISTS public.plots_slots
(
    id bigint NOT NULL,
    plot_id bigint,
    slot_id bigint,
    slot_status integer,
    CONSTRAINT plots_slots_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.plots_slots
    OWNER to postgres;