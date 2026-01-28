package org.tabooproject.fluxon.platform.bukkit.function;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.tabooproject.fluxon.runtime.Environment;
import org.tabooproject.fluxon.runtime.FluxonRuntime;
import org.tabooproject.fluxon.runtime.NativeFunction;
import org.tabooproject.fluxon.runtime.Type;
import taboolib.common.LifeCycle;
import taboolib.common.platform.Awake;
import taboolib.common.platform.Platform;
import taboolib.common.platform.PlatformSide;

import static org.tabooproject.fluxon.runtime.FunctionSignature.returns;

/**
 * Fluxon
 * org.tabooproject.fluxon.extension.bukkit.function.game.compat.FunctionScoreboard
 *
 * @author mical
 * @since 2025/7/21 18:18
 */
@PlatformSide(Platform.BUKKIT)
public class FunctionPlaceholder {

    @Awake(LifeCycle.LOAD)
    public static void init() {
        final FluxonRuntime runtime = FluxonRuntime.getInstance();
        final NativeFunction.NativeCallable<?> function = context -> {
            final Environment env = context.getEnvironment();
            final Player player;
            final String content = context.getString(0);
            if (context.getArgumentCount() > 1) {
                player = (Player) context.getRef(1);
            } else {
                Object find = env.getRootVariables().get("player");
                if (find instanceof Player) {
                    player = (Player) find;
                } else {
                    throw new IllegalStateException("No player found in environment");
                }
            }
            context.setReturnRef(PlaceholderAPI.setPlaceholders(player, content));
        };
        runtime.registerFunction("papi", returns(Type.STRING).params(Type.STRING), function);
        runtime.registerFunction("papi", returns(Type.STRING).params(Type.STRING, Type.OBJECT), function);
        runtime.registerFunction("placeholder", returns(Type.STRING).params(Type.STRING), function);
        runtime.registerFunction("placeholder", returns(Type.STRING).params(Type.STRING, Type.OBJECT), function);
    }
}