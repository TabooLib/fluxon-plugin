
package org.tabooproject.fluxon.platform.bukkit;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.tabooproject.fluxon.Fluxon;
import org.tabooproject.fluxon.platform.bukkit.function.FunctionPlaceholder;
import org.tabooproject.fluxon.platform.bukkit.function.Functions;
import org.tabooproject.fluxon.platform.bukkit.function.PlayerOperators;
import org.tabooproject.fluxon.runtime.Environment;
import org.tabooproject.fluxon.runtime.FluxonRuntime;
import taboolib.common.LifeCycle;
import taboolib.common.platform.Awake;

import java.util.Map;

/**
 * fluxon
 * org.tabooproject.fluxon.extension.org.tabooproject.fluxon.extension.bukkit.FluxonBukkit
 *
 * @author lynn
 * @since 2025/7/20
 */
public class FluxonBukkit {

    @Awake(LifeCycle.INIT)
    public static void init() {
        new Functions(FluxonRuntime.getInstance());
        new FunctionPlaceholder(FluxonRuntime.getInstance());
        PlayerOperators.registerAll(FluxonRuntime.getInstance());
    }

    public static Object runFluxon(@NotNull final CommandSender sender, @NotNull final String script) {
        return runFluxon(sender, script, null);
    }

    public static Object runFluxon(@NotNull final CommandSender sender, @NotNull final String script, @Nullable final Map<String, Object> args) {
        final Environment env = FluxonRuntime.getInstance().newEnvironment();
        if (args != null) {
            for (Map.Entry<String, Object> entry : args.entrySet()) {
                env.defineRootVariable(entry.getKey(), entry.getValue());
            }
        }
        env.defineRootVariable("sender", sender);
        if (sender instanceof Player) {
            env.defineRootVariable("player", sender);
        }
        return Fluxon.eval(script, env);
    }
}