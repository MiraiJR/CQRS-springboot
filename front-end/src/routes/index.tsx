import { createFileRoute } from "@tanstack/react-router";

export const Index = () => {
  return <div className="p-5">This is index page.</div>;
};

export const Route = createFileRoute("/")({
  component: Index,
});
