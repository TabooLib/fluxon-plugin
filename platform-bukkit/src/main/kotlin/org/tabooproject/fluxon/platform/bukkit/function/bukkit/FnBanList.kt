package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.BanList
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBanList {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BanList::class.java)
                .function("banEntry", 1) {
                    // BanEntry<T> getBanEntry(@NotNull String var1)
                    // BanEntry<T> getBanEntry(@NotNull T var1)
                    TODO()
                }
                .function("addBan", 4) {
                    // BanEntry<T> addBan(@NotNull String var1, @Nullable String var2, @Nullable Date var3, @Nullable String var4)
                    // BanEntry<T> addBan(@NotNull T var1, @Nullable String var2, @Nullable Date var3, @Nullable String var4)
                    // BanEntry<T> addBan(@NotNull T var1, @Nullable String var2, @Nullable Instant var3, @Nullable String var4)
                    // BanEntry<T> addBan(@NotNull T var1, @Nullable String var2, @Nullable Duration var3, @Nullable String var4)
                    TODO()
                }
                .function("banEntries", 0) { it.target?.banEntries }
                .function("entries", 0) { it.target?.getEntries() }
                .function("isBanned", 1) {
                    // boolean isBanned(@NotNull T var1)
                    // boolean isBanned(@NotNull String var1)
                    TODO()
                }
                .function("pardon", 1) {
                    // void pardon(@NotNull T var1)
                    // void pardon(@NotNull String var1)
                    TODO()
                }
        }
    }
}
