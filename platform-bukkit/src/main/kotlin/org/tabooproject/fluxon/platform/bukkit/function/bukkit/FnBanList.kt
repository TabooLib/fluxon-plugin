package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.BanList
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.time.Duration
import java.time.Instant
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.BanList"])
@PlatformSide(Platform.BUKKIT)
object FnBanList {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BanList::class.java)
                .function("getBanEntry", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.getBanEntry(var1)
                        else -> (it.target as? BanList<Any>)?.getBanEntry(var1!!)
                    }
                }
                .function("addBan", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.addBan(
                            var1,
                            it.getString(1),
                            it.getRef(2) as? Date,
                            it.getString(3)
                        )

                        else -> when (val var3 = it.getRef(2)) {
                            is Date -> (it.target as? BanList<Any>)?.addBan(
                                var1!!,
                                it.getString(1),
                                var3,
                                it.getString(3)
                            )

                            is Instant -> (it.target as? BanList<Any>)?.addBan(
                                var1!!,
                                it.getString(1),
                                var3,
                                it.getString(3)
                            )

                            is Duration -> (it.target as? BanList<Any>)?.addBan(
                                var1!!,
                                it.getString(1),
                                var3,
                                it.getString(3)
                            )

                            else -> throw IllegalArgumentException("参数 3 必须是 Date, Instant, 或 Duration 类型")
                        }
                    }
                }
                .function("banEntries", returnsObject().noParams()) { it.target?.banEntries }
                .function("entries", returnsObject().noParams()) { it.target?.getEntries() }
                .function("isBanned", returns(Type.Z).params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.isBanned(var1)
                        else -> (it.target as? BanList<Any>)?.isBanned(var1!!)
                    }
                }
                .function("pardon", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.pardon(var1)
                        else -> (it.target as? BanList<Any>)?.pardon(var1!!)
                    }
                }
        }
    }
}
