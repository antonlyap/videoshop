/*
 * Copyright 2013-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package videoshop.catalog;

import static org.salespointframework.core.Currencies.*;

import videoshop.catalog.Disc.DiscType;

import org.javamoney.moneta.Money;
import org.salespointframework.core.DataInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * A {@link DataInitializer} implementation that will create dummy data for the
 * application on application startup.
 *
 * @author Paul Henke
 * @author Oliver Gierke
 * @see DataInitializer
 */
@Component
@Order(20)
class CatalogDataInitializer implements DataInitializer {

	private static final Logger LOG = LoggerFactory.getLogger(CatalogDataInitializer.class);

	private final VideoCatalog videoCatalog;

	CatalogDataInitializer(VideoCatalog videoCatalog) {

		Assert.notNull(videoCatalog, "VideoCatalog must not be null!");

		this.videoCatalog = videoCatalog;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.salespointframework.core.DataInitializer#initialize()
	 */
	@Override
	public void initialize() {

		if (videoCatalog.findAll().iterator().hasNext()) {
			return;
		}

		LOG.info("Creating default catalog entries.");

		videoCatalog.save(new Disc("Last Action Hero", "lac", 12, Money.of(100, EURO), "Äktschn/Comedy", DiscType.DVD));
		videoCatalog.save(new Disc("Back to the Future", "bttf", 16, Money.of(9.99, EURO), "Sci-Fi", DiscType.DVD));
		videoCatalog.save(new Disc("Fido", "fido", 18, Money.of(9.99, EURO), "Comedy/Drama/Horror", DiscType.DVD));
		videoCatalog.save(new Disc("Super Fuzz", "sf", 6, Money.of(9.99, EURO), "Action/Sci-Fi/Comedy", DiscType.DVD));
		videoCatalog.save(new Disc("Armour of God II: Operation Condor", "aog2oc", 0, Money.of(14.99, EURO),
				"Action/Adventure/Comedy", DiscType.DVD));
		videoCatalog
				.save(new Disc("Persepolis", "pers", 16, Money.of(14.99, EURO), "Animation/Biography/Drama", DiscType.DVD));
		videoCatalog
				.save(new Disc("Hot Shots! Part Deux", "hspd", 18, Money.of(9999.0, EURO), "Action/Comedy/War", DiscType.DVD));
		videoCatalog
				.save(new Disc("Avatar: The Last Airbender", "tla", 6, Money.of(19.99, EURO), "Animation/Action/Adventure",
						DiscType.DVD));

		videoCatalog.save(new Disc("Secretary", "secretary", 12, Money.of(6.99, EURO), "Political Drama", DiscType.BLURAY));
		videoCatalog.save(new Disc("The Godfather", "tg", 0, Money.of(19.99, EURO), "Crime/Drama", DiscType.BLURAY));
		videoCatalog
				.save(new Disc("No Retreat, No Surrender", "nrns", 6, Money.of(29.99, EURO), "Martial Arts", DiscType.BLURAY));
		videoCatalog
				.save(new Disc("The Princess Bride", "tpb", 0, Money.of(39.99, EURO), "Adventure/Comedy/Family",
						DiscType.BLURAY));
		videoCatalog.save(new Disc("Top Secret!", "ts", 12, Money.of(39.99, EURO), "Comedy", DiscType.BLURAY));
		videoCatalog
				.save(new Disc("The Iron Giant", "tig", 16, Money.of(34.99, EURO), "Animation/Action/Adventure",
						DiscType.ONLINE));
		videoCatalog
				.save(new Disc("Battle Royale", "br", 6, Money.of(19.99, EURO), "Action/Drama/Thriller", DiscType.ONLINE));
		videoCatalog.save(new Disc("Oldboy", "old", 18, Money.of(24.99, EURO), "Action/Drama/Thriller", DiscType.ONLINE));
		videoCatalog.save(new Disc("Bill & Ted's Excellent Adventure", "bt", 0, Money.of(29.99, EURO),
				"Adventure/Comedy/Family", DiscType.ONLINE));
	}
}
