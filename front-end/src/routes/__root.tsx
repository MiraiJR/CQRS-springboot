import { Link, Outlet, createRootRoute } from "@tanstack/react-router";
import { TanStackRouterDevtools } from "@tanstack/router-devtools";

export const Root = () => {
  return (
    <>
      <div className="bg-black p-3 text-white flex gap-3">
        <Link to="/" className="text-white [&.active]:font-bold">
          Home
        </Link>
        |
        <Link to="/about" className="text-white [&.active]:font-bold">
          About
        </Link>
        |
        <Link to="/product" className="text-white [&.active]:font-bold">
          Product
        </Link>
      </div>
      <Outlet />
      <TanStackRouterDevtools />
    </>
  );
};

export const Route = createRootRoute({
  component: Root,
});
