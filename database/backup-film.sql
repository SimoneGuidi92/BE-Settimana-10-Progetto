PGDMP         ,                z            film    14.1    14.1 	    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16698    film    DATABASE     `   CREATE DATABASE film WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE film;
                postgres    false            �            1259    24873    film    TABLE     �   CREATE TABLE public.film (
    id integer NOT NULL,
    anno integer,
    incasso character varying(255),
    regista character varying(255),
    tipo character varying(255),
    titolo character varying(255)
);
    DROP TABLE public.film;
       public         heap    postgres    false            �            1259    24872    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �          0    24873    film 
   TABLE DATA           H   COPY public.film (id, anno, incasso, regista, tipo, titolo) FROM stdin;
    public          postgres    false    210   v       �           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 7, true);
          public          postgres    false    209            ]           2606    24879    film film_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.film DROP CONSTRAINT film_pkey;
       public            postgres    false    210            �   �  x�U�ɒ�@�s����p��TИKY�X�O�t̜����@S�4�S����&'#5�E��wsG�GJ5������m>,����}��!�$�@� s�e`�&W(������$%�
"h��i��_����ju��ǯ+j6\}s���Ύ��tJφ�u�/7gg;����IC(��O gXIEFf�C&?$�����B�%U�#g�L��T�,��a�.�g�l旺�٫Q
�ҳ�������I��0+`^��QD�[�݂�\a�����7/d�c�^��ȶ�r��M38\�(wtÙ�2�����ƕL	LX��v}�.b4ϩ0���|_[oϛ���m{f�Q٢R06��ʝ� �jb���W�/m�[l���$ig[e��|E���]���V��~��i���q1�8g��?,C�f���������`_�����!c�oY�ߏ�D�q���W��Z�     