-- Populating the city table with real city names for the first 20 countries
INSERT INTO cities (id, name, country_id)
VALUES (1, 'Kabul', 1),                 -- Kabul in Afghanistan
       (2, 'Herat', 1),                 -- Herat in Afghanistan
       (3, 'Tirana', 2),                -- Tirana in Albania
       (4, 'Durres', 2),                -- Durres in Albania
       (5, 'Algiers', 3),               -- Algiers in Algeria
       (6, 'Oran', 3),                  -- Oran in Algeria
       (7, 'Andorra la Vella', 4),      -- Andorra la Vella in Andorra
       (8, 'Escaldes-Engordany', 4),    -- Escaldes-Engordany in Andorra
       (9, 'Luanda', 5),                -- Luanda in Angola
       (10, 'Huambo', 5),               -- Huambo in Angola
       (11, 'St. John''s', 6),          -- St. John's in Antigua and Barbuda
       (12, 'All Saints', 6),           -- All Saints in Antigua and Barbuda
       (13, 'Buenos Aires', 7),         -- Buenos Aires in Argentina
       (14, 'Cordoba', 7),              -- Cordoba in Argentina
       (15, 'Yerevan', 8),              -- Yerevan in Armenia
       (16, 'Gyumri', 8),               -- Gyumri in Armenia
       (17, 'Sydney', 9),               -- Sydney in Australia
       (18, 'Melbourne', 9),            -- Melbourne in Australia
       (19, 'Vienna', 10),              -- Vienna in Austria
       (20, 'Graz', 10),                -- Graz in Austria
       (21, 'Baku', 11),                -- Baku in Azerbaijan
       (22, 'Nassau', 12),              -- Nassau in Bahamas
       (23, 'Manama', 13),              -- Manama in Bahrain
       (24, 'Dhaka', 14),               -- Dhaka in Bangladesh
       (25, 'Bridgetown', 15),          -- Bridgetown in Barbados
       (26, 'Minsk', 16),               -- Minsk in Belarus
       (27, 'Brussels', 17),            -- Brussels in Belgium
       (28, 'Belmopan', 18),            -- Belmopan in Belize
       (29, 'Porto-Novo', 19),          -- Porto-Novo in Benin
       (30, 'Thimphu', 20),             -- Thimphu in Bhutan
       (31, 'La Paz', 21),              -- La Paz in Bolivia
       (32, 'Banja Luka', 22),          -- Banja Luka in Bosnia and Herzegovina
       (33, 'Gaborone', 23),            -- Gaborone in Botswana
       (34, 'Brasilia', 24),            -- Brasilia in Brazil
       (35, 'Bandar Seri Begawan', 25),-- Bandar Seri Begawan in Brunei
       (36, 'Sofia', 26),               -- Sofia in Bulgaria
       (37, 'Ouagadougou', 27),         -- Ouagadougou in Burkina Faso
       (38, 'Bujumbura', 28),           -- Bujumbura in Burundi
       (39, 'Praia', 29),               -- Praia in Cabo Verde
       (40, 'Phnom Penh', 30),          -- Phnom Penh in Cambodia
       (41, 'Yaounde', 31),             -- Yaounde in Cameroon
       (42, 'Ottawa', 32),              -- Ottawa in Canada
       (43, 'Bangui', 33),              -- Bangui in Central African Republic
       (44, 'N''Djamena', 34),          -- N'Djamena in Chad
       (45, 'Santiago', 35),            -- Santiago in Chile
       (46, 'Beijing', 36),             -- Beijing in China
       (47, 'Bogota', 37),              -- Bogota in Colombia
       (48, 'Moroni', 38),              -- Moroni in Comoros
       (49, 'Kinshasa', 39),            -- Kinshasa in Congo, Democratic Republic of the
       (50, 'Brazzaville', 40),         -- Brazzaville in Congo, Republic of the
       (51, 'San Jose', 41),            -- San Jose in Costa Rica
       (52, 'Yamoussoukro', 42),        -- Yamoussoukro in Cote d'Ivoire
       (53, 'Zagreb', 43),              -- Zagreb in Croatia
       (54, 'Havana', 44),              -- Havana in Cuba
       (55, 'Nicosia', 45),             -- Nicosia in Cyprus
       (56, 'Prague', 46),              -- Prague in Czech Republic
       (57, 'Copenhagen', 47),          -- Copenhagen in Denmark
       (58, 'Djibouti', 48),            -- Djibouti in Djibouti
       (59, 'Roseau', 49),              -- Roseau in Dominica
       (60, 'Santo Domingo', 50),       -- Santo Domingo in Dominican Republic
       (61, 'Santa Cruz', 21),          -- Santa Cruz in Bolivia
       (62, 'Banja Luka', 22),          -- Banja Luka in Bosnia and Herzegovina
       (63, 'Gaborone', 23),            -- Gaborone in Botswana
       (64, 'Brasilia', 24),            -- Brasilia in Brazil
       (65, 'Bandar Seri Begawan', 25), -- Bandar Seri Begawan in Brunei
       (66, 'Sofia', 26),               -- Sofia in Bulgaria
       (67, 'Ouagadougou', 27),         -- Ouagadougou in Burkina Faso
       (68, 'Bujumbura', 28),           -- Bujumbura in Burundi
       (69, 'Praia', 29),               -- Praia in Cabo Verde
       (70, 'Phnom Penh', 30),          -- Phnom Penh in Cambodia
       (71, 'Yaounde', 31),             -- Yaounde in Cameroon
       (72, 'Ottawa', 32),              -- Ottawa in Canada
       (73, 'Bangui', 33),              -- Bangui in Central African Republic
       (74, 'N''Djamena', 34),          -- N'Djamena in Chad
       (75, 'Santiago', 35),            -- Santiago in Chile
       (76, 'Beijing', 36),             -- Beijing in China
       (77, 'Bogota', 37),              -- Bogota in Colombia
       (78, 'Moroni', 38),              -- Moroni in Comoros
       (79, 'Kinshasa', 39),            -- Kinshasa in Congo, Democratic Republic of the
       (80, 'Brazzaville', 40),         -- Brazzaville in Congo, Republic of the
       (81, 'San Jose', 41),            -- San Jose in Costa Rica
       (82, 'Yamoussoukro', 42),        -- Yamoussoukro in Cote d'Ivoire
       (83, 'Zagreb', 43),              -- Zagreb in Croatia
       (84, 'Havana', 44),              -- Havana in Cuba
       (85, 'Nicosia', 45),             -- Nicosia in Cyprus
       (86, 'Prague', 46),              -- Prague in Czech Republic
       (87, 'Copenhagen', 47),          -- Copenhagen in Denmark
       (88, 'Djibouti', 48),            -- Djibouti in Djibouti
       (89, 'Roseau', 49),              -- Roseau in Dominica
       (90, 'Santo Domingo', 50),       -- Santo Domingo in Dominican Republic
       (91, 'Quito', 51),               -- Quito in Ecuador
       (92, 'Cairo', 52),               -- Cairo in Egypt
       (93, 'San Salvador', 53),        -- San Salvador in El Salvador
       (94, 'Malabo', 54),              -- Malabo in Equatorial Guinea
       (95, 'Asmara', 55),              -- Asmara in Eritrea
       (96, 'Tallinn', 56),             -- Tallinn in Estonia
       (97, 'Mbabane', 57),             -- Mbabane in Eswatini
       (98, 'Addis Ababa', 58),         -- Addis Ababa in Ethiopia
       (99, 'Suva', 59),                -- Suva in Fiji
       (100, 'Helsinki', 60),           -- Helsinki in Finland
       (101, 'Paris', 61),              -- Paris in France
       (102, 'Libreville', 62),         -- Libreville in Gabon
       (103, 'Banjul', 63),             -- Banjul in Gambia
       (104, 'Tbilisi', 64),            -- Tbilisi in Georgia
       (105, 'Berlin', 65),             -- Berlin in Germany
       (106, 'Accra', 66),              -- Accra in Ghana
       (107, 'Athens', 67),             -- Athens in Greece
       (108, 'St. George''s', 68),      -- St. George's in Grenada
       (109, 'Guatemala City', 69),     -- Guatemala City in Guatemala
       (110, 'Conakry', 70),            -- Conakry in Guinea
       (111, 'Bissau', 71),             -- Bissau in Guinea-Bissau
       (112, 'Georgetown', 72),         -- Georgetown in Guyana
       (113, 'Port-au-Prince', 73),     -- Port-au-Prince in Haiti
       (114, 'Tegucigalpa', 74),        -- Tegucigalpa in Honduras
       (115, 'Budapest', 75),           -- Budapest in Hungary
       (116, 'Reykjavik', 76),          -- Reykjavik in Iceland
       (117, 'New Delhi', 77),          -- New Delhi in India
       (118, 'Jakarta', 78),            -- Jakarta in Indonesia
       (119, 'Tehran', 79),             -- Tehran in Iran
       (120, 'Baghdad', 80),            -- Baghdad in Iraq
       (121, 'Dublin', 81),             -- Dublin in Ireland
       (122, 'Jerusalem', 82),          -- Jerusalem in Israel
       (123, 'Rome', 83),               -- Rome in Italy
       (124, 'Kingston', 84),           -- Kingston in Jamaica
       (125, 'Tokyo', 85),              -- Tokyo in Japan
       (126, 'Amman', 86),              -- Amman in Jordan
       (127, 'Nur-Sultan', 87),         -- Nur-Sultan in Kazakhstan
       (128, 'Nairobi', 88),            -- Nairobi in Kenya
       (129, 'Tarawa', 89),             -- Tarawa in Kiribati
       (130, 'Pyongyang', 90),          -- Pyongyang in North Korea
       (131, 'Seoul', 91),              -- Seoul in South Korea
       (132, 'Pristina', 92),           -- Pristina in Kosovo
       (133, 'Kuwait City', 93),        -- Kuwait City in Kuwait
       (134, 'Bishkek', 94),            -- Bishkek in Kyrgyzstan
       (135, 'Vientiane', 95),          -- Vientiane in Laos
       (136, 'Riga', 96),               -- Riga in Latvia
       (137, 'Beirut', 97),             -- Beirut in Lebanon
       (138, 'Maseru', 98),             -- Maseru in Lesotho
       (139, 'Monrovia', 99),           -- Monrovia in Liberia
       (140, 'Tripoli', 100),           -- Tripoli in Libya
       (141, 'Vaduz', 101),             -- Vaduz in Liechtenstein
       (142, 'Vilnius', 102),           -- Vilnius in Lithuania
       (143, 'Luxembourg', 103),        -- Luxembourg in Luxembourg
       (144, 'Skopje', 104),            -- Skopje in North Macedonia
       (145, 'Antananarivo', 105),      -- Antananarivo in Madagascar
       (146, 'Lilongwe', 106),          -- Lilongwe in Malawi
       (147, 'Kuala Lumpur', 107),      -- Kuala Lumpur in Malaysia
       (148, 'Male', 108),              -- Male in Maldives
       (149, 'Bamako', 109),            -- Bamako in Mali
       (150, 'Valletta', 110),          -- Valletta in Malta
       (151, 'Majuro', 111),            -- Majuro in Marshall Islands
       (152, 'Nouakchott', 112),        -- Nouakchott in Mauritania
       (153, 'Port Louis', 113),        -- Port Louis in Mauritius
       (154, 'Mexico City', 114),       -- Mexico City in Mexico
       (155, 'Palikir', 115),           -- Palikir in Micronesia
       (156, 'Chisinau', 116),          -- Chisinau in Moldova
       (157, 'Monaco', 117),            -- Monaco in Monaco
       (158, 'Ulaanbaatar', 118),       -- Ulaanbaatar in Mongolia
       (159, 'Podgorica', 119),         -- Podgorica in Montenegro
       (160, 'Rabat', 120),             -- Rabat in Morocco
       (161, 'Maputo', 121),            -- Maputo in Mozambique
       (162, 'Nay Pyi Taw', 122),       -- Nay Pyi Taw in Myanmar
       (163, 'Windhoek', 123),          -- Windhoek in Namibia
       (164, 'Yaren', 124),             -- Yaren in Nauru
       (165, 'Kathmandu', 125),         -- Kathmandu in Nepal
       (166, 'Amsterdam', 126),         -- Amsterdam in Netherlands
       (167, 'Wellington', 127),        -- Wellington in New Zealand
       (168, 'Managua', 128),           -- Managua in Nicaragua
       (169, 'Niamey', 129),            -- Niamey in Niger
       (170, 'Abuja', 130),             -- Abuja in Nigeria
       (171, 'Oslo', 131),              -- Oslo in Norway
       (172, 'Muscat', 132),            -- Muscat in Oman
       (173, 'Islamabad', 133),         -- Islamabad in Pakistan
       (174, 'Ngerulmud', 134),         -- Ngerulmud in Palau
       (175, 'Panama City', 135),       -- Panama City in Panama
       (176, 'Port Moresby', 136),      -- Port Moresby in Papua New Guinea
       (177, 'Asuncion', 137),          -- Asuncion in Paraguay
       (178, 'Lima', 138),              -- Lima in Peru
       (179, 'Manila', 139),            -- Manila in Philippines
       (180, 'Warsaw', 140),            -- Warsaw in Poland
       (181, 'Lisbon', 141),            -- Lisbon in Portugal
       (182, 'Doha', 142),              -- Doha in Qatar
       (183, 'Bucharest', 143),         -- Bucharest in Romania
       (184, 'Moscow', 144),            -- Moscow in Russia
       (185, 'Kigali', 145),            -- Kigali in Rwanda
       (186, 'Basseterre', 146),        -- Basseterre in Saint Kitts and Nevis
       (187, 'Castries', 147),          -- Castries in Saint Lucia
       (188, 'Kingstown', 148),         -- Kingstown in Saint Vincent and the Grenadines
       (189, 'Apia', 149),              -- Apia in Samoa
       (190, 'San Marino', 150),        -- San Marino in San Marino
       (191, 'Sao Tome', 151),          -- Sao Tome in Sao Tome and Principe
       (192, 'Riyadh', 152),            -- Riyadh in Saudi Arabia
       (193, 'Dakar', 153),             -- Dakar in Senegal
       (194, 'Belgrade', 154),          -- Belgrade in Serbia
       (195, 'Victoria', 155),          -- Victoria in Seychelles
       (196, 'Freetown', 156),          -- Freetown in Sierra Leone
       (197, 'Singapore', 157),         -- Singapore in Singapore
       (198, 'Bratislava', 158),        -- Bratislava in Slovakia
       (199, 'Ljubljana', 159),         -- Ljubljana in Slovenia
       (200, 'Honiara', 160),           -- Honiara in Solomon Islands
       (201, 'Mogadishu', 161),         -- Mogadishu in Somalia
       (202, 'Pretoria', 162),          -- Pretoria in South Africa
       (203, 'Juba', 163),              -- Juba in South Sudan
       (204, 'Madrid', 164),            -- Madrid in Spain
       (205, 'Colombo', 165),           -- Colombo in Sri Lanka
       (206, 'Khartoum', 166),          -- Khartoum in Sudan
       (207, 'Paramaribo', 167),        -- Paramaribo in Suriname
       (208, 'Stockholm', 168),         -- Stockholm in Sweden
       (209, 'Bern', 169),              -- Bern in Switzerland
       (210, 'Damascus', 170),          -- Damascus in Syria
       (211, 'Taipei', 171),            -- Taipei in Taiwan
       (212, 'Dushanbe', 172),          -- Dushanbe in Tajikistan
       (213, 'Dodoma', 173),            -- Dodoma in Tanzania
       (214, 'Bangkok', 174),           -- Bangkok in Thailand
       (215, 'Dili', 175),              -- Dili in Timor-Leste
       (216, 'Lome', 176),              -- Lome in Togo
       (217, 'Nuku''alofa', 177),       -- Nuku'alofa in Tonga
       (218, 'Port of Spain', 178),     -- Port of Spain in Trinidad and Tobago
       (219, 'Tunis', 179),             -- Tunis in Tunisia
       (220, 'Ankara', 180);            -- Ankara in Turkey