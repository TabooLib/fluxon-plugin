package org.tabooproject.fluxon.platform.bukkit.function.bukkit.profile

import org.bukkit.profile.PlayerTextures
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.profile.PlayerTextures\$SkinModel"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerTexturesSkinModel : FnEnumGetter<PlayerTextures.SkinModel>() {

    override val enumClass: Class<PlayerTextures.SkinModel> = PlayerTextures.SkinModel::class.java
}
