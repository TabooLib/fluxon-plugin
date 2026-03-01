package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.metadata.LazyMetadataValue\$CacheStrategy"])
@PlatformSide(Platform.BUKKIT)
object FnLazyMetadataValueCacheStrategy : FnEnumGetter<org.bukkit.metadata.LazyMetadataValue.CacheStrategy>() {

    override val enumClass: Class<org.bukkit.metadata.LazyMetadataValue.CacheStrategy> = org.bukkit.metadata.LazyMetadataValue.CacheStrategy::class.java
}
