CREATE TABLE IF NOT EXISTS public.plot
(
    id bigint NOT NULL,
    plot_created_date timestamp without time zone,
    crop_name character varying(255) COLLATE pg_catalog."default",
    irrigation_status character varying(255) COLLATE pg_catalog."default",
    owned_by character varying(255) COLLATE pg_catalog."default",
    plot_area bigint,
    plot_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT plot_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.plot
    OWNER to postgres;